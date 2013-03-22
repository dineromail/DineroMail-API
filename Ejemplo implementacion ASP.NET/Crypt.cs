using System;
using System.Collections.Generic;
using System.Text;
using System.Security.Cryptography;
using System.IO;

namespace Dineromail
{
    public class DMCrypt
    {
        private TripleDESCryptoServiceProvider des = new TripleDESCryptoServiceProvider();
        private UTF8Encoding utf8 = new UTF8Encoding();

        private byte[] keyValue;
        private byte[] iVValue;

        public byte[] Key
        {
            get { return keyValue; }
            set 
            { 
                keyValue = value;

                this.iVValue = Encoding.ASCII.GetBytes("uL%&(#(f");
            }
        }

        public byte[] iV
        {
            get { return iVValue; }
            set { iVValue = value; }
        }

        public DMCrypt()
        {
        }

        public byte[] Decrypt(byte[] bytes)
        {
            return Transform(bytes, des.CreateDecryptor(this.keyValue, this.iVValue));
        }

        public byte[] Encrypt(byte[] bytes)
        {
            
            return Transform(bytes, des.CreateEncryptor(this.keyValue, this.iVValue));
        }

        public string Decrypt(string text)
        {
            byte[] input = Convert.FromBase64String(text);
            byte[] output = Transform(input, des.CreateDecryptor(this.keyValue, this.iVValue));
            return utf8.GetString(output);
        }

        public string Encrypt(string text)
        {
            byte[] input = utf8.GetBytes(text);
            byte[] output = Transform(input, des.CreateEncryptor(this.keyValue, this.iVValue));
            return Convert.ToBase64String(output);
        }

        private byte[] Transform(byte[] input, ICryptoTransform cryptoTransform)
        {
            // Create the necessary streams
            MemoryStream memory = new MemoryStream();
            CryptoStream stream = new CryptoStream(memory, cryptoTransform, CryptoStreamMode.Write);

            // Transform the bytes as requesed
            stream.Write(input, 0, input.Length);
            stream.FlushFinalBlock();

            // Read the memory stream and convert it back into byte array
            memory.Position = 0;
            byte[] result = new byte[memory.Length];
            memory.Read(result, 0, result.Length);

            // Clean up
            memory.Close();
            stream.Close();

            // Return result
            return result;
        }

        public string GetHashMD5(string Value)
        {
            MD5CryptoServiceProvider MD5Provider = new MD5CryptoServiceProvider();
            byte[] data = Encoding.ASCII.GetBytes(Value);
            data = MD5Provider.ComputeHash(data);
            string ret = "";
            for (int i = 0; i < data.Length; i++)
            {
                ret += data[i].ToString("x2").ToLower();
            }
            return ret;
        }
    }
}

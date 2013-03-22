DM-API
======
<p>Para que puedas crear tu App integrada con la Plataforma, DineroMail.com expone una API con la que podrás, desde tu sitio web, plataforma, móvil, sistema de facturación yotros diferentes escenarios, de los más simples a los más complejos, realizar operaciones que van desde ingresar a tu cuenta, obtener el saldo, realizar y recibir pagos, recibir información o dirigir acciones de distinto tipo.</p>
            
<h3>¿Qué permite la API?</h3>
<p>La API te ofrecerá posibilidades ilimitadas donde encontrarás una riqueza de servicios para programar. Podrás crear desde una pequeña aplicación para recibir pagos en una red social o en una nómina depagos hasta atender al contexto en el cual el negocio está interactuando con el consumidor.</p>
<p>Desde donde quieras, podrás consumir la API y, en un espacio de programación, a través de las variables que el documento solicita, realizar todo tipo de operaciones sin necesidad de acceder al sitioweb de DineroMail.</p>

<h3>¿Cuáles son los beneficios de la API?</h3>
<ul>
   <li>No es necesario entrar al sitio web de DineroMail.</li>
   <li>Podrás conectar aplicaciones, automatizar procesos y crear cadenas paralelas.</li>
   <li>Podrás integrar DineroMail a las necesidades del sistema del comercio y su flujo de pago.</li>
   <li>Podrás programar servicios de pagos en tus propias aplicaciones.</li>
</ul>

<h3>¿Qué necesitas para utilizar la API?</h3>
<p>No podrás utilizar la API si no eres un usuario avanzado con conocimientos sobre programación.<br/>Además, es necesario tener una Credencial válida. Esta Credencial está compuesta por un usuario y contraseña. Debes buscar el usuario y contraseña de la credencial en tu cuenta de DineroMail accediendo a Datos de Usuario >> Credencial API.</p>

<h3>Credencial - Descripción:</h3>
<p>La Credential es la tarjeta de acceso a la API de DineroMail. La misma está especificada de lasiguiente manera:</p>

<table style="background-color: #009C2F; border-collapse: separate; border-spacing: 1px;">
    <tr><td style="background-color: steelblue; padding: 5px 10px; color: #fff; font-weight: bold;">Nombre</td><td style="background-color: steelblue; padding: 5px 10px; color: #fff; font-weight: bold;">Descripción</td></tr>
    <tr><td style="background-color: #fff; padding: 5px 10px">APIUserName</td><td style="background-color: #fff; padding: 5px 10px">Requerido. Tipo string. Usuario para utilización de la API</td></tr>
    <tr><td style="background-color: #fff; padding: 5px 10px">APIPassword</td><td style="background-color: #fff; padding: 5px 10px">Requerido. Tipo string Password para utilización de la API</td></tr>
</table>
<p>Todos los métodos publicados de la API reciben como primer parámetro la Credential, para podervalidar si el usuario que intenta consumir la API es un usuario válido.</p>

<h3>Métodos publicados de la API</h3>
<ul>                    
    <li>GetBalance</li>
    <li>GetOperations</li>
    <li>SendMoney</li>
    <li>DoWithDraw</li>
    <li>DoPaymentWithReference</li>
    <li>DoPaymentWithBankTransfer</li>
    <li>DoPaymentWithDirectBankTransfer</li>
    <li>DoPaymentWithCreditCard</li>
    <li>GetPaymentTicket</li>
    <li>Refund</li>    
</ul>

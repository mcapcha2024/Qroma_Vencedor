package WebSite;

import org.openqa.selenium.By;

import java.security.PublicKey;

public class Locators {

    // Localizador del Menú
    public static final By logoHome = By.xpath("//*[@id=\"navbar\"]/div/div[1]/a[1]");
    public static final By logoOncosalud = By.xpath("//*[@id=\"navbar\"]/div/div[1]/a[2]");
    public static final By vencedoras = By.xpath("//*[@id=\"menu\"]/li[1]/a");
    public static final By chequeo = By.xpath("//*[@id=\"menu\"]/li[2]/a");
    public static final By colores = By.xpath("//*[@id=\"menu\"]/li[3]/a");
    public static final By botonDescubre = By.xpath("//*[@id=\"menu\"]/li[4]/a");

    // Scroll
    public static final int scrollAmountOne = 220; // Cantidad de píxeles a desplazar
    public static final int scrollAmountTwo = 630; // Cantidad de píxeles a desplazar
    public static final int scrollAmountThree = 2000; // Cantidad de píxeles a desplazar

    // Localizador del Botones
    public static final By botonConoce = By.xpath("//*[@id=\"home-button-redirect-vencedoras\"]/a");
    public static final By botonCual = By.xpath("//*[@id=\"section-01\"]/div/div[1]/div[5]/div/div/div[2]/a");
    public static final By botonChequeo = By.xpath("//*[@id=\"fullpage \"]/div[3]/div/div[2]/div[3]/a");

    // Localizador de colores
    public static final By selectColor = By.xpath("//*[@id=\"content-box\"]/div[1]/div");
    public static final By validarRosa = By.xpath("//*[@id=\"name-lastname\"]");
    public static final By cerrarColor = By.xpath("//*[@id=\"close-icon-modal-story\"]");
    public static final By botonColorRosa = By.xpath("//*[@id=\"fullpage \"]/div[4]/div/div[5]/a");

    // Localizador Footer
    public static final By validarCopy = By.xpath("//*[@id=\"fullpage \"]/div[4]/footer/section/div[1]");
    public static final By linkTermino = By.xpath("//*[@id=\"fullpage \"]/div[4]/footer/section/div[2]");

    // Localizador del formulario de testimonio
    public static final By botonSiguiente = By.xpath("//*[@id=\"next-to-step-2\"]");
    public static final By campoNombre = By.xpath("//*[@id=\"name\"]");
    public static final By valcampoNombre = By.xpath("//*[@id=\"error-name\"]");
    public static final By campoApellido = By.xpath("//*[@id=\"lastname\"]");
    public static final By valcampoApellido = By.xpath("//*[@id=\"error-lastname\"]");
    public static final By campoEmail = By.xpath("//*[@id=\"email\"]");
    public static final By valcampoEmail = By.xpath("//*[@id=\"error-email\"]");
    public static final By campoCelular = By.xpath("//*[@id=\"phone\"]");
    public static final By valcampoCelular = By.xpath("//*[@id=\"error-phone\"]");
    public static final By botonAtras = By.xpath("//*[@id=\"back-to-step-1\"]");
    public static final By campoHistoria = By.xpath("//*[@id=\"testimony\"]");
    public static final By valcampoHistoria = By.xpath("//*[@id=\"error-testimony\"]");
    public static final By linkTerminoHistoria = By.xpath("//*[@id=\"form-step-2\"]/div[2]/label/a");
    public static final By botonTerminar = By.xpath("//*[@id=\"submit-form\"]");
    public static final By valMensajeConfirmacion = By.xpath("//*[@id=\"modal-title-create\"]");
    public static final By botonResultado = By.xpath("//*[@id=\"modal-button-create\"]/a");

    // Localizador de Resultado
    public static final By valTextResultado = By.xpath("//*[@id=\"first-line\"]");
    public static final By botonCompartir = By.xpath("//*[@id=\"share-button\"]");
    public static final By botonCompartirFacebook = By.xpath("//*[@id=\"share-buttons\"]/a[2]");
    public static final By botonCompartirTwitter = By.xpath("//*[@id=\"share-buttons\"]/a[3]");
    public static final By botonCompartirWhatsapp = By.xpath("//*[@id=\"share-buttons\"]/a[5]");
    public static final By botonCompartirEmail = By.xpath("//*[@id=\"share-buttons\"]/a[6]");
    public static final By botonCompartirCopiar = By.xpath("//*[@id=\"copy-url\"]");
    public static final By botonCompartirCerrar = By.xpath("//*[@id=\"close-icon-post\"]");

    // Localizadores Popup 20% DTO
    public static final By polm1Link = By.xpath("/html/body/div[5]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[4]/div[1]/label/span/a");// Identificador del enlace políticas
    public static final By deselm1Box = By.xpath("/html/body/div[5]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[4]/div[2]/input"); // Identificador del checkbox
    public static final By selm1Box = By.xpath("/html/body/div[5]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[4]/div[2]/input"); // Identificador del quitar checkbox
    public static final By promm1Link = By.xpath("/html/body/div[5]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[4]/div[2]/label/span/a"); // Identificador del enlace promociones
    public static final By promm1Cerrar = By.cssSelector("body > div.swal2-container.swal2-center.modal-terms.modal_promociones.swal2-backdrop-show > div > div.swal2-header > button"); // Identificador del cerrar promociones
    public static final By inputm1Celular = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[1]/div/input"); // Identificador del campo Celular
    public static final By inputm1DNI = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[2]/div/input"); // Identificador del campo DNI
    public static final By agendamientom1FechaCombo = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[3]/div/select");
    public static final By registrarm1Button = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/form/div/div[5]/button"); // Identificador del botón Registrar
    public static final By confirmationm1Message = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/p[1]"); //Identifica que el mensaje sea correcto
    public static final By cerrarm1Message = By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-header > button"); //Cerrar mensaje

    // Localizadores Popup Delivery
    public static final By terminosLink = By.xpath("/html/body/div[3]/main/div[3]/div[2]/div[2]/a");// Identificador del enlace términos
    public static final By formularioButton = By.xpath("/html/body/div[3]/main/div[3]/div[2]/div[2]/button"); //Seleccionar botón Lo quiero
    public static final By politicasLink = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[1]/label/span/a");// Identificador del enlace políticas
    public static final By deselpm2Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[2]/label"); // Identificador del checkbox
    public static final By selpm2Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[2]/label"); // Identificador del quitar checkbox
    public static final By promm2Link = By.cssSelector("document.querySelector(\"#formCallMeBanner > div > div.form-group.wide.form-group-tratamiento.order__form__row.order__form__row--checkbox > div:nth-child(2) > label > span > a\")"); // Identificador del enlace promociones
    public static final By promm2Cerrar = By.xpath("/html/body/div[13]/div/div[1]/button"); // Identificador del cerrar promociones
    public static final By deselrm2Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[3]/label"); // Identificador del checkbox
    public static final By selrm2Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[3]/label"); // Identificador del quitar checkbox
    public static final By restm2Link = By.cssSelector("document.querySelector(\"#equip-samsung > label > span > a\")"); // Identificador del enlace restricciones
    public static final By restm2Cerrar = By.cssSelector("body > div.swal2-container.swal2-center.modal-terms.swal2-backdrop-show > div > div.swal2-header > button"); // Identificador del cerrar restricciones
    public static final By inputm2DNI = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[1]/div[1]/input"); // Identificador del campo DNI
    public static final By inputm2Celular = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[1]/div[2]/input"); // Identificador del campo Celular
    public static final By agendamientom2FechaCombo = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[2]/div/select");
    public static final By registrarm2Button = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[4]/button"); // Identificador del botón Registrar
    public static final By confirmationm2Message = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/p[1]"); //Identifica que el mensaje sea correcto
    public static final By cerrarm2Message = By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-header > button"); //Cerrar mensaje
    public static final By cerrarm2Delivery = By.cssSelector("#of-flotante-close > picture > img"); //Cerrar el modal del deliverý

    // Banner
    public static final By cerrarM20Modal = By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-header > button"); // Identificar botón cerrar
    public static final By cerrarMDeModal = By.xpath("/html/body/div[3]/main/div[3]/div[1]"); // Identificar botón cerrar
    public static By getBullet(int index) {
        return By.cssSelector("#multioferta > main > section.home__banner > div > div > ul > li:nth-child(" + index + ")");
    }
    public static final By politicasbannerLink = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[3]/label/a");// Identificador del enlace políticas
    public static final By deselb1Box = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[4]/label"); // Identificador del checkbox
    public static final By selb1Box = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[4]/label"); // Identificador del quitar checkbox
    public static final By promb1Link = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[4]/label/a"); // Identificador del enlace promociones
    public static final By promb1Cerrar = By.cssSelector("body > div.swal2-container.swal2-center.modal-terms.modal_promociones.swal2-backdrop-show > div > div.swal2-header > button"); // Identificador del cerrar promociones
    public static final By inputb1DNI = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[1]/div[1]/input"); // Identificador del campo DNI
    public static final By inputb1Celular = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[1]/div[2]/input"); // Identificador del campo Celular
    public static final By agendamientob1FechaCombo = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[2]/select");
    public static final By registrarb1Button = By.xpath("/html/body/div[3]/main/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[2]/div[5]/button"); // Identificador del botón Registrar

    // Sección Equipos + Plan Contodo
    public static final By openformularioCTButton = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[1]/div/div[2]/section[1]/div/div/div/article[2]/div[2]/button"); //Seleccionar botón Lo quiero
    public static final By polm3Link = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[1]/label/span/a");// Identificador del enlace políticas
    public static final By deselpm3Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[2]/label"); // Identificador del checkbox
    public static final By selpm3Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[2]/label"); // Identificador del quitar checkbox
    public static final By promm3Link = By.cssSelector("#formCallMeBanner > div > div.form-group.wide.form-group-tratamiento.order__form__row.order__form__row--checkbox > div:nth-child(2) > label > span > a"); // Identificador del enlace promociones
    public static final By promm3Cerrar = By.xpath("/html/body/div[13]/div/div[1]/button"); // Identificador del cerrar promociones
    public static final By deselrm3Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[3]/label"); // Identificador del checkbox
    public static final By selrm3Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[3]/label"); // Identificador del quitar checkbox
    public static final By restm3Link = By.cssSelector("#equip-samsung > label > span > a"); // Identificador del enlace restricciones
    public static final By restm3Cerrar = By.cssSelector("body > div.swal2-container.swal2-center.modal-terms.swal2-backdrop-show > div > div.swal2-header > button"); // Identificador del cerrar restricciones
    public static final By inputm3DNI = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[1]/div[1]/input"); // Identificador del campo DNI
    public static final By inputm3Celular = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[1]/div[2]/input"); // Identificador del campo Celular
    public static final By agendamientom3FechaCombo = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[2]/div/select");
    public static final By registrarm3Button = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[4]/button"); // Identificador del botón Registrar
    public static final By confirmationm3Message = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/p[1]"); //Identifica que el mensaje sea correcto
    public static final By cerrarm3Message = By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-header > button"); //Cerrar mensaje

    // Sección Equipos + Plan Equipos
    public static final By marcaSelect = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[1]/div/div[1]/div[1]/div[2]/span[4]"); //Seleccionar una marca
    public static final By openformularioEButton = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[1]/div/div[2]/section[7]/div/div/div/article[2]/div[2]/button"); //Seleccionar botón Lo quiero
    public static final By polm4Link = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[1]/label/span/a");// Identificador del enlace políticas
    public static final By deselpm4Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[2]/label"); // Identificador del checkbox
    public static final By selpm4Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[2]/label"); // Identificador del quitar checkbox
    public static final By promm4Link = By.cssSelector("#formCallMeBanner > div > div.form-group.wide.form-group-tratamiento.order__form__row.order__form__row--checkbox > div:nth-child(2) > label > span > a"); // Identificador del enlace promociones
    public static final By promm4Cerrar = By.xpath("/html/body/div[13]/div/div[1]/button"); // Identificador del cerrar promociones
    public static final By deselrm4Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[3]/label"); // Identificador del checkbox
    public static final By selrm4Box = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[3]/div[3]/label"); // Identificador del quitar checkbox
    public static final By restm4Link = By.cssSelector("#equip-samsung > label > span > a"); // Identificador del enlace restricciones
    public static final By restm4Cerrar = By.cssSelector("/html/body/div[13]/div/div[1]/button"); // Identificador del cerrar restricciones
    public static final By inputm4DNI = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[1]/div[1]/input"); // Identificador del campo DNI
    public static final By inputm4Celular = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[1]/div[2]/input"); // Identificador del campo Celular
    public static final By agendamientom4FechaCombo = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[2]/div/select");
    public static final By registrarm4Button = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/div/div/div[3]/form/div/div[4]/button"); // Identificador del botón Registrar
    public static final By confirmationm4Message = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div/p[1]"); //Identifica que el mensaje sea correcto
    public static final By cerrarm4Message = By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-header > button"); //Cerrar mensaje

    // Sección Equipos sin plan
    public static final By sinplanSelect = By.xpath("/html/body/div[3]/main/section[2]/div/section/ul/li[2]"); //Seleccionar file equipos sin plan
    public static final By loquieroLink = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[2]/div/div/div/div/div[2]/div[3]/a");// Identificador del enlace políticas

    // Sección Solo Plan
    public static final By soloplanSelect = By.xpath("/html/body/div[3]/main/section[2]/div/section/ul/li[3]"); // Ir a la pestaña Solo plan
    public static final By desplegarSPSelect = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[3]/div/div/div/div/div[2]/div[3]"); // Desplegar plan
    public static final By ocultarSPSelect = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[3]/div/div/div/div/div[2]/div[3]/div[2]"); // Contraer plan
    public static final By equipolineaClick = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[3]/div/div/div/div/div[2]/div[2]/a[1]");
    public static final By lineaClick = By.xpath("/html/body/div[3]/main/section[2]/div/section/div/div[3]/div/div/div/div/div[2]/div[2]/a[1]");

    // Sección Promoción
    public static final By solicitaaquiClick = By.xpath("/html/body/div[3]/main/section[3]/div[1]/div[1]/div[1]/div/a");

    // Sección Recomendado
    public static final By recomendadoClick = By.xpath("/html/body/div[3]/main/section[3]/div[1]/div[2]/div[2]/a");

    // Sección Cambiate
    public static final By verofertasClick = By.xpath("/html/body/div[3]/main/section[3]/div[2]/div/div/div/a");

    // Sección Beneficios
    public static final By clickMovistartv = By.xpath("/html/body/div[3]/main/section[4]/div/div/div[1]/div/div/div[1]/a");
    public static final By clickSmartwifi = By.xpath("/html/body/div[3]/main/section[4]/div/div/div[1]/div/div/div[2]/a");
    public static final By clickExclusivos = By.xpath("/html/body/div[3]/main/section[4]/div/div/div[1]/div/div/div[3]/a");

    // Sección Términos y Condiciones
    public static final By clickaTerminos = By.xpath("/html/body/div[3]/main/section[4]/div/div/div[2]/span");
    public static final By validarLegal = By.xpath("/html/body/div[3]/main/section[4]/div/div/section/div/p[6]");
    public static final By clickcTerminos = By.xpath("/html/body/div[3]/main/section[4]/div/div/div[2]/span");

    // Cintillo
    public static final By quitarTratamientos = By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/form/div/div[2]/div/label");
    public static final By agregarTratamientos = By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/form/div/div[2]/div/label");
    public static final By clickTratamientos = By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/form/div/div[2]/div/p/a");
    public static final By cerrarTratamientos = By.xpath("/html/body/div[13]/div/div[1]/button");
    public static final By cintilloDNI = By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/form/div/div[1]/div[1]/input");
    public static final By cintilloCelular = By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/form/div/div[1]/div[2]/input");
    public static final By clickrCintillo = By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/form/div/div[3]/button");
    public static final By confirCintillo = By.xpath("/html/body/div[13]/div/div[2]/div[1]/div/div");
    public static final By cerrarCintillo = By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-header > button");
}

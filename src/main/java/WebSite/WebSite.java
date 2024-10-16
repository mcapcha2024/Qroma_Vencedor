package WebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static WebSite.Locators.*;

public class WebSite {

    private static WebDriver driver;

    public WebSite(WebDriver driver) {
        WebSite.driver = driver;
    }

    public void navigateToWebsite(String url) throws InterruptedException {
        driver.get(url);

        // Use WebDriverWait para espera explícita (recomendado)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));  // Espere la carga básica de la página
    }

    // Navegación del Menú
    public String getLogoLink() {
        WebElement logo = driver.findElement(logoHome);
        return logo.getAttribute("href");
    }

    public void logoOncosalud(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(logoOncosalud).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public String getVenLink() {
        WebElement logo = driver.findElement(vencedoras);
        return logo.getAttribute("href");
    }
    public String getCheLink() {
        WebElement logo = driver.findElement(chequeo);
        return logo.getAttribute("href");
    }
    public String getColoLink() {
        WebElement logo = driver.findElement(colores);
        return logo.getAttribute("href");
    }
    public void getDescebreLink(String hrefEsperado) {
        WebElement boton = driver.findElement(botonDescubre);
        String hrefObtenido = boton.getAttribute("href");
        Assert.assertEquals(hrefObtenido, hrefEsperado, "El valor del href no coincide");
        System.out.println("URL correcta: " + hrefObtenido + " Botón Descubrir tu rosa");
    }

    // Scroll
    public void scrollByPixels(int amount) throws InterruptedException {
        // Desplazar la ventana verticalmente por la cantidad especificada
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + amount + ")");
        Thread.sleep(5000);
    }
    public void scroll2ByPixels(int amount) throws InterruptedException {
        // Desplazar la ventana verticalmente por la cantidad especificada
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -" + amount + ")");
        Thread.sleep(5000);
    }

    public String getConoceLink() {
        WebElement logo = driver.findElement(botonConoce);
        return logo.getAttribute("href");
    }

    public void getCualLink(String hrefEsperado) {
        WebElement boton = driver.findElement(botonCual);
        String hrefObtenido = boton.getAttribute("href");
        Assert.assertEquals(hrefObtenido, hrefEsperado, "El valor del href no coincide");
        System.out.println("URL correcta: " + hrefObtenido + " Botón ¿Cuál es mi color rosa?");
    }

    public void getChequeoLink(String hrefEsperado) {
        WebElement boton = driver.findElement(botonChequeo);
        String hrefObtenido = boton.getAttribute("href");
        Assert.assertEquals(hrefObtenido, hrefEsperado, "El valor del href no coincide");
        System.out.println("URL correcta: " + hrefObtenido + " Botón Chequeo oncológico");
    }

    public void selColores(){
        driver.findElement(selectColor).click();
    }

    public void valRosa(String palabraEsperada) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(validarRosa));
        String textoCompleto = elemento.getText();
        String[] palabras = (textoCompleto.split("\\s+"));
        Thread.sleep(2000);
        String primeraPalabra = palabras[0];
        Thread.sleep(2000);
        Assert.assertEquals(primeraPalabra, palabraEsperada, "La primera palabra no coincide");
        System.out.println("El texto: " + primeraPalabra + " es correcto");
    }

    public void cerrarColores(){
        driver.findElement(cerrarColor).click();
    }

    public void valCopy(String palabraEsperada) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(validarCopy));
        String palabraWeb = elemento.getText();
        Assert.assertEquals(palabraWeb, palabraEsperada, "La primera palabra no coincide");
        System.out.println("El texto: " + palabraWeb + " es correcto");
    }

    public void getTerminosLink(String hrefEsperado) {
        WebElement boton = driver.findElement(linkTermino);
        String hrefObtenido = boton.getAttribute("Text");
        Assert.assertEquals(hrefObtenido, hrefEsperado, "El valor del href no coincide");
        System.out.println("URL correcta: " + hrefObtenido + " Link de Términos y Condiciones");
    }

    public void getbuttonColorRosa(){
        driver.findElement(botonColorRosa).click();
    }

    public void valNombre() {
        //Escenario 1: Campo vacío
        driver.findElement(campoNombre).sendKeys("  ");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(valcampoNombre));
        String mensajeEsperado = "El nombre es obligatorio";
        String mensajeObtenido = mensajeError.getText();
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido + " es correcto");
        //Escenario 2: Sólo números
        driver.findElement(campoNombre).sendKeys("123456789");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(valcampoNombre));
        String mensajeEsperado2 = "El nombre solo debe contener letras y espacios";
        String mensajeObtenido2 = mensajeError2.getText();
        Assert.assertEquals(mensajeObtenido2, mensajeEsperado2, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido2 + " es correcto");
        //Escenario 3: Más de 50 caracteres
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement val50 = wait5.until(ExpectedConditions.presenceOfElementLocated(Locators.campoNombre));
        val50.clear();
        val50.sendKeys("María Jose María Jose María Jose María Jose María J");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(valcampoNombre));
        String mensajeEsperado3 = "El nombre no debe exceder los 50 caracteres";
        String mensajeObtenido3 = mensajeError3.getText();
        Assert.assertEquals(mensajeObtenido3, mensajeEsperado3, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido3 + " es correcto");
        // Escenario 4: Nombre válido
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valOk = wait6.until(ExpectedConditions.presenceOfElementLocated(Locators.campoNombre));
        valOk.clear();
        valOk.sendKeys("María Jose");
    }

    public void valApellido(){
        //Escenario 1: Campo vacío
        driver.findElement(campoApellido).sendKeys("  ");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(valcampoApellido));
        String mensajeEsperado = "El apellido es obligatorio";
        String mensajeObtenido = mensajeError.getText();
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido + " es correcto");
        //Escenario 2: Sólo números
        driver.findElement(campoApellido).sendKeys("123456789");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(valcampoApellido));
        String mensajeEsperado2 = "El apellido solo debe contener letras y espacios";
        String mensajeObtenido2 = mensajeError2.getText();
        Assert.assertEquals(mensajeObtenido2, mensajeEsperado2, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido2 + " es correcto");
        //Escenario 3: Más de 50 caracteres
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement val50 = wait5.until(ExpectedConditions.presenceOfElementLocated(campoApellido));
        val50.clear();
        val50.sendKeys("María Jose María Jose María Jose María Jose María J");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(valcampoApellido));
        String mensajeEsperado3 = "El apellido no debe exceder los 50 caracteres";
        String mensajeObtenido3 = mensajeError3.getText();
        Assert.assertEquals(mensajeObtenido3, mensajeEsperado3, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido3 + " es correcto");
        // Escenario 4: Nombre válido
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valOk = wait6.until(ExpectedConditions.presenceOfElementLocated(campoApellido));
        valOk.clear();
        valOk.sendKeys("Gutiérrez Fernández");
    }

    public void valEmail(){
        //Escenario 1: Campo vacío
        driver.findElement(botonSiguiente).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(valcampoEmail));
        String mensajeEsperado = "El correo electrónico es obligatorio";
        String mensajeObtenido = mensajeError.getText();
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido + " es correcto");
        //Escenario 2: Correo incompleto
        driver.findElement(campoEmail).sendKeys("!\"#%&/()=(/&%$#32432@gmail");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(valcampoEmail));
        String mensajeEsperado2 = "El email debe ser válido y contener un @ y un punto después del @";
        String mensajeObtenido2 = mensajeError2.getText();
        Assert.assertEquals(mensajeObtenido2, mensajeEsperado2, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido2 + " es correcto");
        // Escenario 3: Correo válido
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valOk = wait6.until(ExpectedConditions.presenceOfElementLocated(campoEmail));
        valOk.clear();
        valOk.sendKeys("mcapchaleonardo@gmail.com");
    }

    public void valCelular(){
        //Escenario 1: Campo vacío
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(valcampoCelular));
        String mensajeEsperado = "El número de celular es requerido";
        String mensajeObtenido = mensajeError.getText();
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido + " es correcto");
        //Escenario 2: Cantidad de dígitos
        driver.findElement(campoCelular).sendKeys("90000000");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(valcampoCelular));
        String mensajeEsperado2 = "El celular debe tener exactamente 9 dígitos";
        String mensajeObtenido2 = mensajeError2.getText();
        Assert.assertEquals(mensajeObtenido2, mensajeEsperado2, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido2 + " es correcto");
        //Escenario 3: Comenzar con el 9
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement val9 = wait5.until(ExpectedConditions.presenceOfElementLocated(campoCelular));
        val9.clear();
        val9.sendKeys("000000000");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(valcampoCelular));
        String mensajeEsperado3 = "El celular debe comenzar con el número 9";
        String mensajeObtenido3 = mensajeError3.getText();
        Assert.assertEquals(mensajeObtenido3, mensajeEsperado3, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido3 + " es correcto");
        // Escenario 4: Nombre válido
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valOk = wait6.until(ExpectedConditions.presenceOfElementLocated(campoCelular));
        valOk.clear();
        valOk.sendKeys("900000000");
    }

    public void valSiguiente(String correoUnico) {
        //Escenario 1: Correo registrado
        driver.findElement(botonSiguiente).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(valcampoEmail));
        String mensajeEsperado = "Email ya registrado";
        String mensajeObtenido = mensajeError.getText();
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido + " es correcto");
        // Registro de Contacto
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valOk = wait2.until(ExpectedConditions.presenceOfElementLocated(campoEmail));
        valOk.clear();
        valOk.sendKeys(correoUnico);
        driver.findElement(botonSiguiente).click();
    }

    public void valTerminar() {
        //Escenario 1: Campo obligatorio
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valRegresar = wait3.until(ExpectedConditions.elementToBeClickable(botonAtras));
        valRegresar.click();
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valSiguiente = wait5.until(ExpectedConditions.elementToBeClickable(botonSiguiente));
        valSiguiente.click();
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valTerminar = wait4.until(ExpectedConditions.elementToBeClickable(botonTerminar));
        valTerminar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(valcampoHistoria));
        String mensajeEsperado = "Escribir tu historia es obligatorio";
        String mensajeObtenido = mensajeError.getText();
        Assert.assertEquals(mensajeObtenido, mensajeEsperado, "El mensaje de error no coincide con el esperado");
        System.out.println("El mensaje: " + mensajeObtenido + " es correcto");
        // Ingreso de contenido
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valOk = wait2.until(ExpectedConditions.presenceOfElementLocated(campoHistoria));
        valOk.clear();
        valOk.sendKeys("\"Mi nombre es María. Hace tres años, me diagnosticaron cáncer de mama. Fue un golpe duro, pero decidí enfrentarlo con la misma fuerza en la que mi madre enfrentó el cáncer, apoyo y esperanza de mi familia.\n" +
                "\n" +
                "El camino estaba lleno de pruebas médicas y tratamientos agotadores, pero también de amor, apoyo y esperanza de mi familia. En los días más oscuros, encontré luz en la sonrisa de mi hija, en la mano firme de mi esposo, en las palabras alentadoras de mis amigos, fuerza en la que mi madre enfrentó el cáncer\"\n");
        // Validar Link de Términos
        WebElement linkTer = driver.findElement(linkTerminoHistoria);
        String hrefEsperado = "https://vencedora-dev.vml.pe/create#";
        String hrefObtenido = linkTer.getAttribute("href");
        Assert.assertEquals(hrefObtenido, hrefEsperado, "El valor del href no coincide");
        System.out.println("URL correcta: " + hrefObtenido + " Link de Términos y Condiciones");
        driver.findElement(botonTerminar).click();
        // Validar mensaje de confirmación
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement confTestimonio = wait6.until(ExpectedConditions.visibilityOfElementLocated(valMensajeConfirmacion));
        String hrefEsperado2 = "¡CELEBRAMOS TU FORTALEZA!";
        String hrefObtenido2 = confTestimonio.getText();
        Assert.assertEquals(hrefObtenido2, hrefEsperado2, "El texto no coincide con el esperado");
        System.out.println("El mensaje de confirmación: " + hrefObtenido2 + " Modal Resultado");
        driver.findElement(botonResultado).click();
    }

    public void valResultado(){
        // Validar texto Resultado
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement confTestimonio = wait6.until(ExpectedConditions.visibilityOfElementLocated((valTextResultado)));
        String hrefEsperado = "Tu rosa es...";
        String hrefObtenido = confTestimonio.getText();
        Assert.assertEquals(hrefObtenido, hrefEsperado, "El texto no coincide con el esperado");
        System.out.println("El texto de saludo es: " + hrefObtenido + " Página Resultado");
        driver.findElement(botonCompartir).click();
        // Validar Icono de Facebook
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By iconoCompartirFacebook = botonCompartirFacebook;
        WebElement botonCompartir = wait.until(ExpectedConditions.visibilityOfElementLocated(iconoCompartirFacebook));
        Assert.assertTrue(botonCompartir.isDisplayed(), "El botón de compartir en Facebook no está visible");
        System.out.println("Visible Facebook");
        // Validar Icono de Twitter
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By iconoCompartirTwitter = botonCompartirTwitter;
        WebElement botonCompartir2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(iconoCompartirTwitter));
        Assert.assertTrue(botonCompartir2.isDisplayed(), "El botón de compartir en Twitter no está visible");
        System.out.println("Visible Twitter");
        // Validar Icono de Whatsapp
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By iconoCompartirWhatsapp = botonCompartirWhatsapp;
        WebElement botonCompartir3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(iconoCompartirWhatsapp));
        Assert.assertTrue(botonCompartir3.isDisplayed(), "El botón de compartir en Whatsapp no está visible");
        System.out.println("Visible Whatsapp");
        // Validar Icono de Email
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By iconoCompartirEmail = botonCompartirEmail;
        WebElement botonCompartir4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(iconoCompartirEmail));
        Assert.assertTrue(botonCompartir4.isDisplayed(), "El botón de compartir en Twitter no está visible");
        System.out.println("Visible Email");
        // Validar Icono de Copiar
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By iconoCompartirCopiar = botonCompartirCopiar;
        WebElement botonCompartir5 = wait5.until(ExpectedConditions.visibilityOfElementLocated(iconoCompartirCopiar));
        Assert.assertTrue(botonCompartir5.isDisplayed(), "El botón de compartir en Copiar no está visible");
        System.out.println("Visible Copiar");
        driver.findElement(botonCompartirCerrar).click();
    }

    /*
    // Navegación Form 20% DTO
    public void validate20DTO(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.polm1Link).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void selectLegal20DTO() throws InterruptedException {
        driver.findElement(Locators.deselm1Box).click();
        Thread.sleep(500);
        driver.findElement(Locators.selm1Box).click();
        Thread.sleep(500);
        driver.findElement(Locators.promm1Link).click();
        Thread.sleep(1000);
        driver.findElement(Locators.promm1Cerrar).click();
        Thread.sleep(1000);
    }

    public void inputFormulatio20DTO(String celular, String dni) {
        driver.findElement(Locators.inputm1Celular).sendKeys(celular);
        driver.findElement(Locators.inputm1DNI).sendKeys(dni);
    }

    public static void selectHorario20DTO(String horario) throws InterruptedException {
        Select agendamientoFechaSelect = new Select(driver.findElement(Locators.agendamientom1FechaCombo));
        agendamientoFechaSelect.selectByValue(horario);
        Thread.sleep(1000);
    }

    public void submitPedido20DTO() throws InterruptedException {
        driver.findElement(Locators.registrarm1Button).click();
        Thread.sleep(5000);
    }

    public String validatePedido20STO() {
        return driver.findElement(Locators.confirmationm1Message).getText();
    }

    public void closeModal20DTO() throws InterruptedException {
        driver.findElement(Locators.cerrarm1Message).click();
        Thread.sleep(1000);
    }

    // Navegación Form DELIVERY
    public void validateTerminosDelivery(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.terminosLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void openFormularioDelivery() throws InterruptedException {
        driver.findElement(Locators.formularioButton).click();
        Thread.sleep(2000);
    }

    public void validatePoliticas(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.politicasLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void selectPromNove() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.deselpm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.selpm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.promm2Link).click();
        //Thread.sleep(2000);
        //driver.findElement(Locators.promm2Cerrar).click();
        //Thread.sleep(2000);
    }

    public void selectRestricciones() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.deselrm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.selrm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.restm2Link).click();
        //Thread.sleep(2000);
        //driver.findElement(Locators.restm2Cerrar).click();
        //Thread.sleep(2000);
    }

    public void inputFormulario(String celular, String dni) {
        driver.findElement(Locators.inputm2DNI).sendKeys(dni);
        driver.findElement(Locators.inputm2Celular).sendKeys(celular);
    }

    public static void selectHorario(String horario) throws InterruptedException {
        Select agendamientoFechaSelect = new Select(driver.findElement(Locators.agendamientom2FechaCombo));
        agendamientoFechaSelect.selectByValue(horario);
        Thread.sleep(1000);
    }

    public void submitPedido() throws InterruptedException {
        driver.findElement(Locators.registrarm2Button).click();
        Thread.sleep(5000);
    }

    public String validarPedido() {
        return driver.findElement(Locators.confirmationm2Message).getText();
    }

    public void closeModal() throws InterruptedException {
        driver.findElement(Locators.cerrarm2Message).click();
        Thread.sleep(1000);
    }

    public void closeModalDelivery() throws InterruptedException{
        driver.findElement(Locators.cerrarm2Delivery).click();
        Thread.sleep(2000);
    }

    // Navegación BANNER
    public void cerrarModales() throws InterruptedException {
        driver.findElement(Locators.cerrarM20Modal).click();
        Thread.sleep(5000);
        driver.findElement(Locators.cerrarMDeModal).click();
        Thread.sleep(5000);
    }

    public void selecB1Bullet(int index) throws InterruptedException {
        driver.findElement(Locators.getBullet(index)).click();
        Thread.sleep(5000);
    }

    public void validatePoliticasBanner(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.politicasbannerLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void selectPromNoveBanner() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.deselb1Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.selb1Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.promb1Link).click();
        //Thread.sleep(3000);
        //driver.findElement(Locators.promb1Cerrar).click();
        //Thread.sleep(1000);
    }

    public void inputFormularioBanner(String celular, String dni) {
        driver.findElement(Locators.inputb1Celular).sendKeys(celular);
        driver.findElement(Locators.inputb1DNI).sendKeys(dni);
    }

    public static void selectHorarioBanner(String horario) throws InterruptedException {
        Select agendamientoFechaSelect = new Select(driver.findElement(Locators.agendamientob1FechaCombo));
        agendamientoFechaSelect.selectByValue(horario);
        Thread.sleep(2000);
    }

    public void submitPedidoBanner() throws InterruptedException {
        driver.findElement(Locators.registrarb1Button).click();
        Thread.sleep(5000);
    }

    // Sección Equipos + Plan Contodo
    public void openFormularioContodo() throws InterruptedException {
        driver.findElement(Locators.openformularioCTButton).click();
        Thread.sleep(5000);
    }

    // Sección Equipos + Plan EQUIPOS
    public void selectMarca() throws InterruptedException {
        driver.findElement(Locators.marcaSelect).click();
        Thread.sleep(3000);
    }

    public void openFormularioEquipos() throws InterruptedException {
        driver.findElement(Locators.openformularioEButton).click();
        Thread.sleep(5000);
    }

    // File Equipos Sin Plan
    public void selectEquiposSinplan() throws InterruptedException{
        driver.findElement(Locators.sinplanSelect).click();
        Thread.sleep(1000);
    }

    public void validateLoquiero(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.loquieroLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
        Thread.sleep(1000);
    }

    // File Solo Plan
    public void selectSoloplan() throws InterruptedException{
        driver.findElement(Locators.soloplanSelect).click();
        Thread.sleep(2000);
    }

    public void selectdetalleSoloplan() throws InterruptedException{
        driver.findElement((Locators.desplegarSPSelect)).click();
        Thread.sleep(1000);
        driver.findElement((Locators.ocultarSPSelect)).click();
        Thread.sleep(1000);
    }

    public void clickEquipolinea() throws InterruptedException{
        driver.findElement((Locators.equipolineaClick)).click();
        Thread.sleep(1000);
    }

    public void abrir2M5EnlaceEnNuevaVentana(String url) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle(); // Obtener el identificador de ventana actual
        driver.findElement(Locators.polm4Link).click(); // Click en el enlace Políticas
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tiempo máximo de espera (10)
        wait.until(ExpectedConditions.numberOfWindowsToBe(3)); // Cantidad de páginas (2)
        // Validar que la URL nueva sea igual al Enlace
        for (String handle : driver.getWindowHandles()) {
            if (handle.equals(handlePaginaActual)) {  // Si deseas pasar a la nueva ventana agrear el signo de admiración "!" antes de handle.equals
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(5000);
    }

    public void clickLinea() throws InterruptedException{
        driver.findElement((Locators.lineaClick)).click();
        Thread.sleep(1000);
    }

    // Promociones
    public void clickPromociones() throws InterruptedException{
        driver.findElement((Locators.solicitaaquiClick)).click();
        Thread.sleep(1000);
    }

    // Recomendado
    public void clickRecomendado() throws InterruptedException{
        driver.findElement((Locators.recomendadoClick)).click();
        Thread.sleep(1000);
    }

    // Cambiate
    public void validateVerofertas(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.verofertasClick).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    // Beneficios
    public void validateMovistartv(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.clickMovistartv).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void validateSmartwifi(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.clickSmartwifi).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void validateExclusivos(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.clickExclusivos).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    // Términos y Condiciones
    public void desplegarTerminos() throws InterruptedException{
        driver.findElement(Locators.clickaTerminos).click();
        Thread.sleep(1000);
    }

    public String validarVencimiento() {
        return driver.findElement(Locators.validarLegal).getText();
    }

    public void contraerTerminos() throws InterruptedException{
        driver.findElement(Locators.clickcTerminos).click();
        Thread.sleep(1000);
    }

    // Cintillo
    public void selectCintillo() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.quitarTratamientos);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.agregarTratamientos);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.clickTratamientos).click();
        //Thread.sleep(1000);
        //driver.findElement(Locators.cerrarTratamientos).click();
        //Thread.sleep(1000);
    }

    public void formCintillo(String celular, String dni) {
        driver.findElement(Locators.cintilloDNI).sendKeys(dni);
        driver.findElement(Locators.cintilloCelular).sendKeys(celular);
    }

    public void registrarCintillo() throws InterruptedException{
        driver.findElement(Locators.clickrCintillo).click();
        Thread.sleep(3000);
    }*/
}

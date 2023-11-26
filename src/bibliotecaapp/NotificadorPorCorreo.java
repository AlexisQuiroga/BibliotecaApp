
package bibliotecaapp;

// Clase que implementa la interfaz Notificable para enviar notificaciones por correo
public class NotificadorPorCorreo implements Notificable {
    private String direccionCorreo;

    // Constructor
    public NotificadorPorCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    // Método de la interfaz para enviar notificaciones por correo
    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando notificación por correo a " + direccionCorreo + ": " + mensaje);
        // Lógica para enviar notificación por correo (puedes utilizar bibliotecas de envío de correos electrónicos aquí)
    }

    // Otros métodos según sea necesario
    // Por ejemplo, métodos para establecer o cambiar la dirección de correo
    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }
}

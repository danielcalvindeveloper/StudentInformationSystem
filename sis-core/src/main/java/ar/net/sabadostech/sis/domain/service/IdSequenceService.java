package ar.net.sabadostech.sis.domain.service;

/**
 * Servicio para generar secuencias únicas por prefijo de entidad.
 */
public interface IdSequenceService {

    /**
     * Retorna el siguiente número de secuencia para el prefijo dado (ej. STU, TCH).
     * @param prefix prefijo del tipo de entidad
     * @return valor numérico incremental
     */
    int next(String prefix);
}
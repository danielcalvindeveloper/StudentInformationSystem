package ar.net.sabadostech.sis.infrastructure.sequence;

import ar.net.sabadostech.sis.domain.service.IdSequenceService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementación en memoria del servicio de secuencia, útil para pruebas o entornos sin persistencia.
 */
public class InMemoryIdSequenceService implements IdSequenceService {

    private final ConcurrentHashMap<String, AtomicInteger> counters = new ConcurrentHashMap<>();

    @Override
    public int next(String prefix) {
        return counters.computeIfAbsent(prefix, p -> new AtomicInteger(0)).incrementAndGet();
    }
}
package hf;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public interface u extends Closeable, Flushable {
    void b0(long j5, f fVar);

    y c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}

package ue;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class z implements Closeable {
    public abstract long a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ve.b.c(v());
    }

    public abstract q d();

    public abstract hf.h v();
}

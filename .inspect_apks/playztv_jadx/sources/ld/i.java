package ld;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends Exception {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g f8149u;

    public i(String str) {
        super(str);
        this.f8149u = g.f8138x;
    }

    public final g a() {
        return this.f8149u;
    }

    public i(String str, IOException iOException) {
        super(str, iOException);
        this.f8149u = g.f8139y;
    }
}

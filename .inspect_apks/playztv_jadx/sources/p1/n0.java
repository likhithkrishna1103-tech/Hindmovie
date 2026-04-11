package p1;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class n0 extends IOException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f9948u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9949v;

    public n0(String str, Throwable th, boolean z2, int i) {
        super(str, th);
        this.f9948u = z2;
        this.f9949v = i;
    }

    public static n0 a(RuntimeException runtimeException, String str) {
        return new n0(str, runtimeException, true, 1);
    }

    public static n0 b(String str, Exception exc) {
        return new n0(str, exc, true, 4);
    }

    public static n0 c(String str) {
        return new n0(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String message = super.getMessage();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(message != null ? message.concat(" ") : "");
        sb2.append("{contentIsMalformed=");
        sb2.append(this.f9948u);
        sb2.append(", dataType=");
        return x.c.a(sb2, this.f9949v, "}");
    }
}

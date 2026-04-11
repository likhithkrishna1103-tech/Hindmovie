package v1;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class n0 extends IOException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f12878v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f12879w;

    public n0(String str, Throwable th, boolean z10, int i) {
        super(str, th);
        this.f12878v = z10;
        this.f12879w = i;
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
        StringBuilder sb = new StringBuilder();
        sb.append(message != null ? message.concat(" ") : "");
        sb.append("{contentIsMalformed=");
        sb.append(this.f12878v);
        sb.append(", dataType=");
        return q4.a.o(sb, this.f12879w, "}");
    }
}

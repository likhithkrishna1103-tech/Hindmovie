package b2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class l extends IOException {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f1700w = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1701v;

    public l(int i) {
        this.f1701v = i;
    }

    public l(Exception exc, int i) {
        super(exc);
        this.f1701v = i;
    }

    public l(int i, String str) {
        super(str);
        this.f1701v = i;
    }

    public l(String str, Exception exc, int i) {
        super(str, exc);
        this.f1701v = i;
    }
}

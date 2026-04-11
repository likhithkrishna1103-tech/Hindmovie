package b2;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f1684v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f1685w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Uri f1686x;

    public f0(h hVar) {
        hVar.getClass();
        this.f1684v = hVar;
        this.f1686x = Uri.EMPTY;
        Map map = Collections.EMPTY_MAP;
    }

    @Override // b2.h
    public final long B(o oVar) {
        h hVar = this.f1684v;
        this.f1686x = oVar.f1714a;
        Map map = Collections.EMPTY_MAP;
        try {
            return hVar.B(oVar);
        } finally {
            Uri uriT = hVar.t();
            if (uriT != null) {
                this.f1686x = uriT;
            }
            hVar.j();
        }
    }

    @Override // b2.h
    public final void close() {
        this.f1684v.close();
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
        h0Var.getClass();
        this.f1684v.d(h0Var);
    }

    @Override // b2.h
    public final Map j() {
        return this.f1684v.j();
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) {
        int i11 = this.f1684v.read(bArr, i, i10);
        if (i11 != -1) {
            this.f1685w += (long) i11;
        }
        return i11;
    }

    @Override // b2.h
    public final Uri t() {
        return this.f1684v.t();
    }
}

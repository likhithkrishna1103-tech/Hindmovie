package b2;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements h {
    public e A;
    public h B;
    public j0 C;
    public f D;
    public e0 E;
    public h F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f1721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f1722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f1723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public w f1724y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f1725z;

    public p(Context context, h hVar) {
        this.f1721v = context.getApplicationContext();
        hVar.getClass();
        this.f1723x = hVar;
        this.f1722w = new ArrayList();
    }

    public static void c(h hVar, h0 h0Var) {
        if (hVar != null) {
            hVar.d(h0Var);
        }
    }

    @Override // b2.h
    public final long B(o oVar) {
        y1.d.g(this.F == null);
        Uri uri = oVar.f1714a;
        String scheme = uri.getScheme();
        int i = y1.a0.f14551a;
        String scheme2 = uri.getScheme();
        boolean zIsEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f1721v;
        if (zIsEmpty || Objects.equals(scheme2, "file")) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f1724y == null) {
                    w wVar = new w(false);
                    this.f1724y = wVar;
                    b(wVar);
                }
                this.F = this.f1724y;
            } else {
                if (this.f1725z == null) {
                    b bVar = new b(context);
                    this.f1725z = bVar;
                    b(bVar);
                }
                this.F = this.f1725z;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f1725z == null) {
                b bVar2 = new b(context);
                this.f1725z = bVar2;
                b(bVar2);
            }
            this.F = this.f1725z;
        } else if ("content".equals(scheme)) {
            if (this.A == null) {
                e eVar = new e(context);
                this.A = eVar;
                b(eVar);
            }
            this.F = this.A;
        } else {
            boolean zEquals = "rtmp".equals(scheme);
            h hVar = this.f1723x;
            if (zEquals) {
                if (this.B == null) {
                    try {
                        h hVar2 = (h) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.B = hVar2;
                        b(hVar2);
                    } catch (ClassNotFoundException unused) {
                        y1.b.p("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e9) {
                        throw new RuntimeException("Error instantiating RTMP extension", e9);
                    }
                    if (this.B == null) {
                        this.B = hVar;
                    }
                }
                this.F = this.B;
            } else if ("udp".equals(scheme)) {
                if (this.C == null) {
                    j0 j0Var = new j0();
                    this.C = j0Var;
                    b(j0Var);
                }
                this.F = this.C;
            } else if ("data".equals(scheme)) {
                if (this.D == null) {
                    f fVar = new f(false);
                    this.D = fVar;
                    b(fVar);
                }
                this.F = this.D;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.E == null) {
                    e0 e0Var = new e0(context);
                    this.E = e0Var;
                    b(e0Var);
                }
                this.F = this.E;
            } else {
                this.F = hVar;
            }
        }
        return this.F.B(oVar);
    }

    public final void b(h hVar) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1722w;
            if (i >= arrayList.size()) {
                return;
            }
            hVar.d((h0) arrayList.get(i));
            i++;
        }
    }

    @Override // b2.h
    public final void close() {
        h hVar = this.F;
        if (hVar != null) {
            try {
                hVar.close();
            } finally {
                this.F = null;
            }
        }
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
        h0Var.getClass();
        this.f1723x.d(h0Var);
        this.f1722w.add(h0Var);
        c(this.f1724y, h0Var);
        c(this.f1725z, h0Var);
        c(this.A, h0Var);
        c(this.B, h0Var);
        c(this.C, h0Var);
        c(this.D, h0Var);
        c(this.E, h0Var);
    }

    @Override // b2.h
    public final Map j() {
        h hVar = this.F;
        return hVar == null ? Collections.EMPTY_MAP : hVar.j();
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) {
        h hVar = this.F;
        hVar.getClass();
        return hVar.read(bArr, i, i10);
    }

    @Override // b2.h
    public final Uri t() {
        h hVar = this.F;
        if (hVar == null) {
            return null;
        }
        return hVar.t();
    }
}

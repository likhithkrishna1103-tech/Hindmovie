package v1;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements h {
    public h A;
    public g0 B;
    public f C;
    public b0 D;
    public h E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f13164u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f13165v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f13166w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t f13167x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f13168y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e f13169z;

    public n(Context context, h hVar) {
        this.f13164u = context.getApplicationContext();
        hVar.getClass();
        this.f13166w = hVar;
        this.f13165v = new ArrayList();
    }

    public static void c(h hVar, e0 e0Var) {
        if (hVar != null) {
            hVar.g(e0Var);
        }
    }

    public final void b(h hVar) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f13165v;
            if (i >= arrayList.size()) {
                return;
            }
            hVar.g((e0) arrayList.get(i));
            i++;
        }
    }

    @Override // v1.h
    public final void close() {
        h hVar = this.E;
        if (hVar != null) {
            try {
                hVar.close();
            } finally {
                this.E = null;
            }
        }
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f13166w.g(e0Var);
        this.f13165v.add(e0Var);
        c(this.f13167x, e0Var);
        c(this.f13168y, e0Var);
        c(this.f13169z, e0Var);
        c(this.A, e0Var);
        c(this.B, e0Var);
        c(this.C, e0Var);
        c(this.D, e0Var);
    }

    @Override // v1.h
    public final long h(m mVar) {
        s1.d.g(this.E == null);
        Uri uri = mVar.f13157a;
        String scheme = uri.getScheme();
        int i = s1.b0.f11647a;
        String scheme2 = uri.getScheme();
        boolean zIsEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f13164u;
        if (zIsEmpty || Objects.equals(scheme2, "file")) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f13167x == null) {
                    t tVar = new t(false);
                    this.f13167x = tVar;
                    b(tVar);
                }
                this.E = this.f13167x;
            } else {
                if (this.f13168y == null) {
                    b bVar = new b(context);
                    this.f13168y = bVar;
                    b(bVar);
                }
                this.E = this.f13168y;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f13168y == null) {
                b bVar2 = new b(context);
                this.f13168y = bVar2;
                b(bVar2);
            }
            this.E = this.f13168y;
        } else if ("content".equals(scheme)) {
            if (this.f13169z == null) {
                e eVar = new e(context);
                this.f13169z = eVar;
                b(eVar);
            }
            this.E = this.f13169z;
        } else {
            boolean zEquals = "rtmp".equals(scheme);
            h hVar = this.f13166w;
            if (zEquals) {
                if (this.A == null) {
                    try {
                        h hVar2 = (h) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.A = hVar2;
                        b(hVar2);
                    } catch (ClassNotFoundException unused) {
                        s1.b.p("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e10) {
                        throw new RuntimeException("Error instantiating RTMP extension", e10);
                    }
                    if (this.A == null) {
                        this.A = hVar;
                    }
                }
                this.E = this.A;
            } else if ("udp".equals(scheme)) {
                if (this.B == null) {
                    g0 g0Var = new g0();
                    this.B = g0Var;
                    b(g0Var);
                }
                this.E = this.B;
            } else if ("data".equals(scheme)) {
                if (this.C == null) {
                    f fVar = new f(false);
                    this.C = fVar;
                    b(fVar);
                }
                this.E = this.C;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.D == null) {
                    b0 b0Var = new b0(context);
                    this.D = b0Var;
                    b(b0Var);
                }
                this.E = this.D;
            } else {
                this.E = hVar;
            }
        }
        return this.E.h(mVar);
    }

    @Override // v1.h
    public final Map k() {
        h hVar = this.E;
        return hVar == null ? Collections.EMPTY_MAP : hVar.k();
    }

    @Override // v1.h
    public final Uri o() {
        h hVar = this.E;
        if (hVar == null) {
            return null;
        }
        return hVar.o();
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) {
        h hVar = this.E;
        hVar.getClass();
        return hVar.read(bArr, i, i10);
    }
}

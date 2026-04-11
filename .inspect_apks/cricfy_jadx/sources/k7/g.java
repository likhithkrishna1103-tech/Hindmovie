package k7;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.n;
import com.bumptech.glide.p;
import java.util.ArrayList;
import x6.l;
import z6.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v6.d f7225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f7226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f7228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a7.b f7229e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f7231h;
    public d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f7233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f7234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f7235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7238p;

    public g(com.bumptech.glide.b bVar, v6.d dVar, int i, int i10, Bitmap bitmap) {
        a7.b bVar2 = bVar.f2193v;
        com.bumptech.glide.g gVar = bVar.f2195x;
        p pVarD = com.bumptech.glide.b.d(gVar.getBaseContext());
        n nVarY = com.bumptech.glide.b.d(gVar.getBaseContext()).i().a(((o7.g) ((o7.g) ((o7.g) new o7.g().e(m.f15288b)).w()).t()).n(i, i10));
        this.f7227c = new ArrayList();
        this.f7228d = pVarD;
        Handler handler = new Handler(Looper.getMainLooper(), new f(0, this));
        this.f7229e = bVar2;
        this.f7226b = handler;
        this.f7231h = nVarY;
        this.f7225a = dVar;
        c(f7.c.f3990b, bitmap);
    }

    public final void a() {
        int i;
        if (!this.f || this.f7230g) {
            return;
        }
        d dVar = this.f7235m;
        if (dVar != null) {
            this.f7235m = null;
            b(dVar);
            return;
        }
        this.f7230g = true;
        v6.d dVar2 = this.f7225a;
        v6.b bVar = dVar2.f13487l;
        int i10 = bVar.f13467c;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) ((i10 <= 0 || (i = dVar2.f13486k) < 0) ? 0 : (i < 0 || i >= i10) ? -1 : ((v6.a) bVar.f13469e.get(i)).i));
        int i11 = (dVar2.f13486k + 1) % dVar2.f13487l.f13467c;
        dVar2.f13486k = i11;
        this.f7233k = new d(this.f7226b, i11, jUptimeMillis);
        n nVarF = this.f7231h.a((o7.g) new o7.g().s(new r7.b(Double.valueOf(Math.random())))).F(dVar2);
        nVarF.C(this.f7233k, null, nVarF, s7.f.f11596a);
    }

    public final void b(d dVar) {
        this.f7230g = false;
        boolean z10 = this.f7232j;
        Handler handler = this.f7226b;
        if (z10) {
            handler.obtainMessage(2, dVar).sendToTarget();
            return;
        }
        if (!this.f) {
            this.f7235m = dVar;
            return;
        }
        if (dVar.B != null) {
            Bitmap bitmap = this.f7234l;
            if (bitmap != null) {
                this.f7229e.d(bitmap);
                this.f7234l = null;
            }
            d dVar2 = this.i;
            this.i = dVar;
            ArrayList arrayList = this.f7227c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) ((e) arrayList.get(size));
                Object callback = bVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    bVar.stop();
                    bVar.invalidateSelf();
                } else {
                    bVar.invalidateSelf();
                    d dVar3 = ((g) bVar.f7212v.f1841b).i;
                    if ((dVar3 != null ? dVar3.f7222z : -1) == r5.f7225a.f13487l.f13467c - 1) {
                        bVar.A++;
                    }
                    int i = bVar.B;
                    if (i != -1 && bVar.A >= i) {
                        bVar.stop();
                    }
                }
            }
            if (dVar2 != null) {
                handler.obtainMessage(2, dVar2).sendToTarget();
            }
        }
        a();
    }

    public final void c(l lVar, Bitmap bitmap) {
        s7.f.c(lVar, "Argument must not be null");
        s7.f.c(bitmap, "Argument must not be null");
        this.f7234l = bitmap;
        this.f7231h = this.f7231h.a(new o7.g().v(lVar, true));
        this.f7236n = s7.m.c(bitmap);
        this.f7237o = bitmap.getWidth();
        this.f7238p = bitmap.getHeight();
    }
}

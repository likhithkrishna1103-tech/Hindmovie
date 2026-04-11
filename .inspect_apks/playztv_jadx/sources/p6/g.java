package p6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.k;
import com.bumptech.glide.m;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a6.d f10228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f10229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f10231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f6.a f10232e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f10234h;
    public d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f10236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f10237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f10238m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10239n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10240o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10241p;

    public g(com.bumptech.glide.b bVar, a6.d dVar, int i, int i10, Bitmap bitmap) {
        f6.a aVar = bVar.f2760u;
        com.bumptech.glide.e eVar = bVar.f2762w;
        Context baseContext = eVar.getBaseContext();
        x6.f.c(baseContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        m mVarB = com.bumptech.glide.b.a(baseContext).f2764y.b(baseContext);
        Context baseContext2 = eVar.getBaseContext();
        x6.f.c(baseContext2, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        k kVarA = com.bumptech.glide.b.a(baseContext2).f2764y.b(baseContext2).i().a(((t6.g) ((t6.g) ((t6.g) new t6.g().e(e6.m.f4535b)).y()).u()).n(i, i10));
        this.f10230c = new ArrayList();
        this.f10231d = mVarB;
        Handler handler = new Handler(Looper.getMainLooper(), new f(0, this));
        this.f10232e = aVar;
        this.f10229b = handler;
        this.f10234h = kVarA;
        this.f10228a = dVar;
        c(k6.c.f7064b, bitmap);
    }

    public final void a() {
        int i;
        if (!this.f || this.f10233g) {
            return;
        }
        d dVar = this.f10238m;
        if (dVar != null) {
            this.f10238m = null;
            b(dVar);
            return;
        }
        this.f10233g = true;
        a6.d dVar2 = this.f10228a;
        a6.b bVar = dVar2.f602l;
        int i10 = bVar.f582c;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) ((i10 <= 0 || (i = dVar2.f601k) < 0) ? 0 : (i < 0 || i >= i10) ? -1 : ((a6.a) bVar.f584e.get(i)).i));
        int i11 = (dVar2.f601k + 1) % dVar2.f602l.f582c;
        dVar2.f601k = i11;
        this.f10236k = new d(this.f10229b, i11, jUptimeMillis);
        k kVarG = this.f10234h.a((t6.g) new t6.g().t(new w6.d(Double.valueOf(Math.random())))).G(dVar2);
        kVarG.E(this.f10236k, null, kVarG, x6.f.f14280a);
    }

    public final void b(d dVar) {
        this.f10233g = false;
        boolean z2 = this.f10235j;
        Handler handler = this.f10229b;
        if (z2) {
            handler.obtainMessage(2, dVar).sendToTarget();
            return;
        }
        if (!this.f) {
            this.f10238m = dVar;
            return;
        }
        if (dVar.A != null) {
            Bitmap bitmap = this.f10237l;
            if (bitmap != null) {
                this.f10232e.f(bitmap);
                this.f10237l = null;
            }
            d dVar2 = this.i;
            this.i = dVar;
            ArrayList arrayList = this.f10230c;
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
                    d dVar3 = ((g) bVar.f10213u.f5886b).i;
                    if ((dVar3 != null ? dVar3.f10224y : -1) == r5.f10228a.f602l.f582c - 1) {
                        bVar.f10218z++;
                    }
                    int i = bVar.A;
                    if (i != -1 && bVar.f10218z >= i) {
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

    public final void c(c6.m mVar, Bitmap bitmap) {
        x6.f.c(mVar, "Argument must not be null");
        x6.f.c(bitmap, "Argument must not be null");
        this.f10237l = bitmap;
        this.f10234h = this.f10234h.a(new t6.g().w(mVar, true));
        this.f10239n = x6.m.c(bitmap);
        this.f10240o = bitmap.getWidth();
        this.f10241p = bitmap.getHeight();
    }
}

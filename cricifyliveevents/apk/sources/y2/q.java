package y2;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import java.util.concurrent.CopyOnWriteArraySet;
import ua.g0;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f14709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f14710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f14712e;
    public final y1.v f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet f14713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pa.o f14714h = new pa.o();
    public y1.x i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Pair f14715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14717l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14718m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14719n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14720o;

    public q(g2.k kVar) {
        this.f14708a = (Context) kVar.f4781x;
        o oVar = (o) kVar.f4783z;
        y1.d.h(oVar);
        this.f14709b = oVar;
        this.f14710c = new SparseArray();
        g0 g0Var = i0.f12341w;
        z0 z0Var = z0.f12413z;
        this.f14711d = kVar.f4779v;
        y1.v vVar = (y1.v) kVar.A;
        this.f = vVar;
        this.f14712e = new c((v) kVar.f4782y, vVar);
        this.f14713g = new CopyOnWriteArraySet();
        new v1.o().a();
        this.f14718m = -9223372036854775807L;
        this.f14720o = -1;
        this.f14717l = 0;
    }
}

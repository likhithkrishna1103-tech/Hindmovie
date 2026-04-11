package androidx.media3.exoplayer.dash;

import androidx.emoji2.text.v;
import b2.g;
import com.google.android.gms.internal.measurement.o4;
import f3.a;
import f9.a0;
import f9.z;
import j2.h;
import java.util.List;
import l2.o;
import nb.w;
import s2.b0;
import v1.g0;
import w2.q;
import x3.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class DashMediaSource$Factory implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f1267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f1268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f1269e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q5.a f1271h;

    public DashMediaSource$Factory(g gVar) {
        a aVar = new a(gVar);
        this.f1265a = aVar;
        this.f1266b = gVar;
        this.f1267c = new v(29);
        this.f1269e = new a0(28);
        this.f = 30000L;
        this.f1270g = 5000000L;
        this.f1268d = new z(23);
        ((o4) aVar.f3937y).f2560v = true;
    }

    @Override // s2.b0
    public final b0 a(boolean z10) {
        ((o4) this.f1265a.f3937y).f2560v = z10;
        return this;
    }

    @Override // s2.b0
    public final b0 b() {
        ((o4) this.f1265a.f3937y).getClass();
        return this;
    }

    @Override // s2.b0
    public final b0 c(e eVar) {
        o4 o4Var = (o4) this.f1265a.f3937y;
        o4Var.getClass();
        o4Var.f2561w = eVar;
        return this;
    }

    @Override // s2.b0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final h d(g0 g0Var) {
        g0Var.f12697b.getClass();
        q eVar = this.f1271h;
        if (eVar == null) {
            eVar = new k2.e();
        }
        List list = g0Var.f12697b.f12609e;
        return new h(g0Var, this.f1266b, !list.isEmpty() ? new w(9, eVar, list) : eVar, this.f1265a, this.f1268d, this.f1267c.d(g0Var), this.f1269e, this.f, this.f1270g);
    }
}

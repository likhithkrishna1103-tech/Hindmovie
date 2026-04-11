package r3;

import s1.u;
import w2.h0;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f11389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f11390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f11391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11392e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11394h;
    public int i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11398m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11388a = new e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public pb.c f11395j = new pb.c(4, false);

    public void a(long j5) {
        this.f11393g = j5;
    }

    public abstract long b(u uVar);

    public abstract boolean c(u uVar, long j5, pb.c cVar);

    public void d(boolean z2) {
        if (z2) {
            this.f11395j = new pb.c(4, false);
            this.f = 0L;
            this.f11394h = 0;
        } else {
            this.f11394h = 1;
        }
        this.f11392e = -1L;
        this.f11393g = 0L;
    }
}

package a2;

import android.content.SharedPreferences;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e2 implements d1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f209w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f210x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f211y;

    public e2(k8.z0 z0Var, String str, long j5) {
        this.f211y = z0Var;
        t7.v.d(str);
        this.f210x = str;
        this.f207u = j5;
    }

    public void a(long j5) {
        this.f207u = j5;
        if (this.f208v) {
            ((s1.w) this.f210x).getClass();
            this.f209w = SystemClock.elapsedRealtime();
        }
    }

    public void b() {
        if (this.f208v) {
            return;
        }
        ((s1.w) this.f210x).getClass();
        this.f209w = SystemClock.elapsedRealtime();
        this.f208v = true;
    }

    public long c() {
        if (!this.f208v) {
            this.f208v = true;
            this.f209w = ((k8.z0) this.f211y).x1().getLong((String) this.f210x, this.f207u);
        }
        return this.f209w;
    }

    public void d(long j5) {
        SharedPreferences.Editor editorEdit = ((k8.z0) this.f211y).x1().edit();
        editorEdit.putLong((String) this.f210x, j5);
        editorEdit.apply();
        this.f209w = j5;
    }

    @Override // a2.d1
    public void e(p1.q0 q0Var) {
        if (this.f208v) {
            a(j());
        }
        this.f211y = q0Var;
    }

    @Override // a2.d1
    public p1.q0 h() {
        return (p1.q0) this.f211y;
    }

    @Override // a2.d1
    public /* synthetic */ boolean i() {
        return false;
    }

    @Override // a2.d1
    public long j() {
        long j5 = this.f207u;
        if (!this.f208v) {
            return j5;
        }
        ((s1.w) this.f210x).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f209w;
        p1.q0 q0Var = (p1.q0) this.f211y;
        return (q0Var.f10038a == 1.0f ? s1.b0.O(jElapsedRealtime) : jElapsedRealtime * ((long) q0Var.f10040c)) + j5;
    }

    public e2(s1.w wVar) {
        this.f210x = wVar;
        this.f211y = p1.q0.f10036d;
    }
}

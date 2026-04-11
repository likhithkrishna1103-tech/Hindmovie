package u2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f12652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f12653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12655d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12657g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12659j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12663n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12656e = 0;
    public long f = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12658h = -9223372036854775807L;
    public long i = -9223372036854775807L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12660k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s1.w f12661l = s1.w.f11715a;

    public v(Context context, j jVar, long j5) {
        this.f12652a = jVar;
        this.f12654c = j5;
        this.f12653b = new z(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(long r27, long r29, long r31, long r33, boolean r35, boolean r36, q3.a r37) {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.v.a(long, long, long, long, boolean, boolean, q3.a):int");
    }

    public final boolean b(boolean z2) {
        if (z2 && (this.f12656e == 3 || (!this.f12662m && this.f12663n))) {
            this.i = -9223372036854775807L;
            return true;
        }
        if (this.i == -9223372036854775807L) {
            return false;
        }
        this.f12661l.getClass();
        if (SystemClock.elapsedRealtime() < this.i) {
            return true;
        }
        this.i = -9223372036854775807L;
        return false;
    }

    public final void c(boolean z2) {
        long jElapsedRealtime;
        this.f12659j = z2;
        long j5 = this.f12654c;
        if (j5 > 0) {
            this.f12661l.getClass();
            jElapsedRealtime = SystemClock.elapsedRealtime() + j5;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.i = jElapsedRealtime;
    }

    public final void d() {
        this.f12655d = true;
        this.f12661l.getClass();
        this.f12657g = s1.b0.O(SystemClock.elapsedRealtime());
        z zVar = this.f12653b;
        zVar.f12678d = true;
        zVar.f12685m = 0L;
        zVar.f12688p = -1L;
        zVar.f12686n = -1L;
        x xVar = zVar.f12676b;
        if (xVar != null) {
            DisplayManager displayManager = xVar.f12668a;
            y yVar = zVar.f12677c;
            yVar.getClass();
            yVar.f12672v.sendEmptyMessage(2);
            displayManager.registerDisplayListener(xVar, s1.b0.n(null));
            z.a(xVar.f12669b, displayManager.getDisplay(0));
        }
        zVar.d(false);
    }

    public final void e() {
        this.f12655d = false;
        this.i = -9223372036854775807L;
        z zVar = this.f12653b;
        zVar.f12678d = false;
        x xVar = zVar.f12676b;
        if (xVar != null) {
            xVar.f12668a.unregisterDisplayListener(xVar);
            y yVar = zVar.f12677c;
            yVar.getClass();
            yVar.f12672v.sendEmptyMessage(3);
        }
        zVar.b();
    }

    public final void f(int i) {
        if (i == 0) {
            this.f12656e = 1;
        } else if (i == 1) {
            this.f12656e = 0;
        } else {
            if (i != 2) {
                throw new IllegalStateException();
            }
            this.f12656e = Math.min(this.f12656e, 2);
        }
    }

    public final void g(float f) {
        z zVar = this.f12653b;
        zVar.f = f;
        e eVar = zVar.f12675a;
        eVar.f12572a.c();
        eVar.f12573b.c();
        eVar.f12574c = false;
        eVar.f12575d = -9223372036854775807L;
        eVar.f12576e = 0;
        zVar.c();
    }

    public final void h(Surface surface) {
        this.f12662m = surface != null;
        this.f12663n = false;
        z zVar = this.f12653b;
        if (zVar.f12679e != surface) {
            zVar.b();
            zVar.f12679e = surface;
            zVar.d(true);
        }
        this.f12656e = Math.min(this.f12656e, 1);
    }

    public final void i(float f) {
        s1.d.b(f > 0.0f);
        if (f == this.f12660k) {
            return;
        }
        this.f12660k = f;
        z zVar = this.f12653b;
        zVar.i = f;
        zVar.f12685m = 0L;
        zVar.f12688p = -1L;
        zVar.f12686n = -1L;
        zVar.d(false);
    }
}

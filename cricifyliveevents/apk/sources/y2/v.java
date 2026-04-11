package y2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f14728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f14729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14731d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14733g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14735j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14739n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14732e = 0;
    public long f = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14734h = -9223372036854775807L;
    public long i = -9223372036854775807L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14736k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y1.v f14737l = y1.v.f14615a;

    public v(Context context, j jVar, long j4) {
        this.f14728a = jVar;
        this.f14730c = j4;
        this.f14729b = new z(context);
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
    public final int a(long r27, long r29, long r31, long r33, boolean r35, boolean r36, u3.a r37) {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.v.a(long, long, long, long, boolean, boolean, u3.a):int");
    }

    public final boolean b(boolean z10) {
        if (z10 && (this.f14732e == 3 || (!this.f14738m && this.f14739n))) {
            this.i = -9223372036854775807L;
            return true;
        }
        if (this.i == -9223372036854775807L) {
            return false;
        }
        this.f14737l.getClass();
        if (SystemClock.elapsedRealtime() < this.i) {
            return true;
        }
        this.i = -9223372036854775807L;
        return false;
    }

    public final void c(boolean z10) {
        long jElapsedRealtime;
        this.f14735j = z10;
        long j4 = this.f14730c;
        if (j4 > 0) {
            this.f14737l.getClass();
            jElapsedRealtime = SystemClock.elapsedRealtime() + j4;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.i = jElapsedRealtime;
    }

    public final void d() {
        this.f14731d = true;
        this.f14737l.getClass();
        this.f14733g = y1.a0.O(SystemClock.elapsedRealtime());
        z zVar = this.f14729b;
        zVar.f14754d = true;
        zVar.f14761m = 0L;
        zVar.f14764p = -1L;
        zVar.f14762n = -1L;
        x xVar = zVar.f14752b;
        if (xVar != null) {
            DisplayManager displayManager = xVar.f14744a;
            y yVar = zVar.f14753c;
            yVar.getClass();
            yVar.f14748w.sendEmptyMessage(2);
            displayManager.registerDisplayListener(xVar, y1.a0.n(null));
            z.a(xVar.f14745b, displayManager.getDisplay(0));
        }
        zVar.d(false);
    }

    public final void e() {
        this.f14731d = false;
        this.i = -9223372036854775807L;
        z zVar = this.f14729b;
        zVar.f14754d = false;
        x xVar = zVar.f14752b;
        if (xVar != null) {
            xVar.f14744a.unregisterDisplayListener(xVar);
            y yVar = zVar.f14753c;
            yVar.getClass();
            yVar.f14748w.sendEmptyMessage(3);
        }
        zVar.b();
    }

    public final void f(int i) {
        if (i == 0) {
            this.f14732e = 1;
        } else if (i == 1) {
            this.f14732e = 0;
        } else {
            if (i != 2) {
                throw new IllegalStateException();
            }
            this.f14732e = Math.min(this.f14732e, 2);
        }
    }

    public final void g(float f) {
        z zVar = this.f14729b;
        zVar.f = f;
        e eVar = zVar.f14751a;
        eVar.f14651a.c();
        eVar.f14652b.c();
        eVar.f14653c = false;
        eVar.f14654d = -9223372036854775807L;
        eVar.f14655e = 0;
        zVar.c();
    }

    public final void h(Surface surface) {
        this.f14738m = surface != null;
        this.f14739n = false;
        z zVar = this.f14729b;
        if (zVar.f14755e != surface) {
            zVar.b();
            zVar.f14755e = surface;
            zVar.d(true);
        }
        this.f14732e = Math.min(this.f14732e, 1);
    }

    public final void i(float f) {
        y1.d.b(f > 0.0f);
        if (f == this.f14736k) {
            return;
        }
        this.f14736k = f;
        z zVar = this.f14729b;
        zVar.i = f;
        zVar.f14761m = 0L;
        zVar.f14764p = -1L;
        zVar.f14762n = -1L;
        zVar.d(false);
    }
}

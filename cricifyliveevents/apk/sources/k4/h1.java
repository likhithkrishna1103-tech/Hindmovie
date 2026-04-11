package k4;

import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import java.util.List;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements v1.w0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.w0 f7038v;

    public h1(v1.w0 w0Var) {
        this.f7038v = w0Var;
    }

    @Override // v1.w0
    public final void A(boolean z10) {
        D0();
        this.f7038v.A(z10);
    }

    public final v1.j0 A0() {
        return Z(18) ? P0() : v1.j0.K;
    }

    public final v1.v0 B() {
        boolean Z = Z(16);
        boolean Z2 = Z(17);
        return new v1.v0(null, Z2 ? Y() : 0, Z ? z() : null, null, Z2 ? O() : 0, Z ? V0() : 0L, Z ? q() : 0L, Z ? X() : -1, Z ? k0() : -1);
    }

    @Override // v1.w0
    public final void B0() {
        D0();
        this.f7038v.B0();
    }

    public final n1 C() {
        boolean Z = Z(16);
        return new n1(B(), Z && l(), SystemClock.elapsedRealtime(), Z ? getDuration() : -9223372036854775807L, Z ? v() : 0L, Z ? H() : 0, Z ? r() : 0L, Z ? p() : -9223372036854775807L, Z ? N() : -9223372036854775807L, Z ? G0() : 0L);
    }

    @Override // v1.w0
    public final boolean C0() {
        D0();
        return this.f7038v.C0();
    }

    @Override // v1.w0
    public final void D() {
        D0();
        this.f7038v.D();
    }

    public final void D0() {
        y1.d.g(Looper.myLooper() == this.f7038v.y0());
    }

    @Override // v1.w0
    public final int E() {
        D0();
        return this.f7038v.E();
    }

    @Override // v1.w0
    public final v1.l1 E0() {
        D0();
        return this.f7038v.E0();
    }

    @Override // v1.w0
    public final void F(int i) {
        D0();
        this.f7038v.F(i);
    }

    @Override // v1.w0
    public final void F0(long j4) {
        D0();
        this.f7038v.F0(j4);
    }

    @Override // v1.w0
    public final v1.n1 G() {
        D0();
        return this.f7038v.G();
    }

    @Override // v1.w0
    public final long G0() {
        D0();
        return this.f7038v.G0();
    }

    @Override // v1.w0
    public final int H() {
        D0();
        return this.f7038v.H();
    }

    @Override // v1.w0
    public final void H0(int i, int i10) {
        D0();
        this.f7038v.H0(i, i10);
    }

    @Override // v1.w0
    public final void I(int i, v1.g0 g0Var) {
        D0();
        this.f7038v.I(i, g0Var);
    }

    @Override // v1.w0
    public final void I0(int i) {
        D0();
        this.f7038v.I0(i);
    }

    @Override // v1.w0
    public final long J() {
        D0();
        return this.f7038v.J();
    }

    @Override // v1.w0
    public final void J0() {
        D0();
        this.f7038v.J0();
    }

    @Override // v1.w0
    public final void K(v1.g0 g0Var) {
        D0();
        this.f7038v.K(g0Var);
    }

    @Override // v1.w0
    public final void K0() {
        D0();
        this.f7038v.K0();
    }

    @Override // v1.w0
    public final v1.j0 L() {
        D0();
        return this.f7038v.L();
    }

    @Override // v1.w0
    public final void L0(TextureView textureView) {
        D0();
        this.f7038v.L0(textureView);
    }

    @Override // v1.w0
    public final boolean M() {
        D0();
        return this.f7038v.M();
    }

    @Override // v1.w0
    public final void M0() {
        D0();
        this.f7038v.M0();
    }

    @Override // v1.w0
    public final long N() {
        D0();
        return this.f7038v.N();
    }

    @Override // v1.w0
    public final void N0(v1.j0 j0Var) {
        D0();
        this.f7038v.N0(j0Var);
    }

    @Override // v1.w0
    public final int O() {
        D0();
        return this.f7038v.O();
    }

    @Override // v1.w0
    public final void O0(float f) {
        D0();
        this.f7038v.O0(f);
    }

    @Override // v1.w0
    public final x1.c P() {
        D0();
        return this.f7038v.P();
    }

    @Override // v1.w0
    public final v1.j0 P0() {
        D0();
        return this.f7038v.P0();
    }

    @Override // v1.w0
    public final void Q(TextureView textureView) {
        D0();
        this.f7038v.Q(textureView);
    }

    @Override // v1.w0
    public final void Q0(List list) {
        D0();
        this.f7038v.Q0(list);
    }

    @Override // v1.w0
    public final r1 R() {
        D0();
        return this.f7038v.R();
    }

    @Override // v1.w0
    public final void R0() {
        D0();
        this.f7038v.R0();
    }

    @Override // v1.w0
    public final void S() {
        D0();
        this.f7038v.S();
    }

    @Override // v1.w0
    public final void T() {
        D0();
        this.f7038v.T();
    }

    @Override // v1.w0
    public final void T0(v1.u0 u0Var) {
        D0();
        this.f7038v.T0(new v1.q(this, u0Var));
    }

    @Override // v1.w0
    public final float U() {
        D0();
        return this.f7038v.U();
    }

    @Override // v1.w0
    public final void V() {
        D0();
        this.f7038v.V();
    }

    @Override // v1.w0
    public final long V0() {
        D0();
        return this.f7038v.V0();
    }

    @Override // v1.w0
    public final v1.c W() {
        D0();
        return this.f7038v.W();
    }

    @Override // v1.w0
    public final long W0() {
        D0();
        return this.f7038v.W0();
    }

    @Override // v1.w0
    public final int X() {
        D0();
        return this.f7038v.X();
    }

    @Override // v1.w0
    public final boolean X0() {
        D0();
        return this.f7038v.X0();
    }

    @Override // v1.w0
    public final int Y() {
        D0();
        return this.f7038v.Y();
    }

    @Override // v1.w0
    public final boolean Z(int i) {
        D0();
        return this.f7038v.Z(i);
    }

    @Override // v1.w0
    public final boolean a() {
        D0();
        return this.f7038v.a();
    }

    public final v1.g0 a0() {
        if (Z(16)) {
            return z();
        }
        return null;
    }

    @Override // v1.w0
    public final void b() {
        D0();
        this.f7038v.b();
    }

    @Override // v1.w0
    public final void b0(int i, boolean z10) {
        D0();
        this.f7038v.b0(i, z10);
    }

    @Override // v1.w0
    public final void c() {
        D0();
        this.f7038v.c();
    }

    @Override // v1.w0
    public final v1.i c0() {
        D0();
        return this.f7038v.c0();
    }

    @Override // v1.w0
    public final v1.q0 d() {
        D0();
        return this.f7038v.d();
    }

    @Override // v1.w0
    public final void d0() {
        D0();
        this.f7038v.d0();
    }

    @Override // v1.w0
    public final void e(float f) {
        D0();
        this.f7038v.e(f);
    }

    @Override // v1.w0
    public final void e0(v1.l1 l1Var) {
        D0();
        this.f7038v.e0(l1Var);
    }

    @Override // v1.w0
    public final void f(v1.q0 q0Var) {
        D0();
        this.f7038v.f(q0Var);
    }

    public final v1.f1 f0() {
        return Z(17) ? v0() : Z(16) ? v0().p() ? v1.f1.f12674a : new g1(this) : v1.f1.f12674a;
    }

    @Override // v1.w0
    public final void g(List list, int i, long j4) {
        D0();
        this.f7038v.g(list, i, j4);
    }

    @Override // v1.w0
    public final void g0(int i) {
        D0();
        this.f7038v.g0(i);
    }

    @Override // v1.w0
    public final long getDuration() {
        D0();
        return this.f7038v.getDuration();
    }

    @Override // v1.w0
    public final v1.p0 h() {
        D0();
        return this.f7038v.h();
    }

    @Override // v1.w0
    public final void h0(int i, int i10) {
        D0();
        this.f7038v.h0(i, i10);
    }

    @Override // v1.w0
    public final int i() {
        D0();
        return this.f7038v.i();
    }

    @Override // v1.w0
    public final void i0(boolean z10) {
        D0();
        this.f7038v.i0(z10);
    }

    @Override // v1.w0
    public final void j(boolean z10) {
        D0();
        this.f7038v.j(z10);
    }

    @Override // v1.w0
    public final void j0(int i) {
        D0();
        this.f7038v.j0(i);
    }

    @Override // v1.w0
    public final void k(Surface surface) {
        D0();
        this.f7038v.k(surface);
    }

    @Override // v1.w0
    public final int k0() {
        D0();
        return this.f7038v.k0();
    }

    @Override // v1.w0
    public final boolean l() {
        D0();
        return this.f7038v.l();
    }

    @Override // v1.w0
    public final void l0(SurfaceView surfaceView) {
        D0();
        this.f7038v.l0(surfaceView);
    }

    @Override // v1.w0
    public final void m(int i) {
        D0();
        this.f7038v.m(i);
    }

    @Override // v1.w0
    public final void m0(v1.u0 u0Var) {
        D0();
        this.f7038v.m0(new v1.q(this, u0Var));
    }

    @Override // v1.w0
    public final void n(v1.g0 g0Var, long j4) {
        D0();
        this.f7038v.n(g0Var, j4);
    }

    @Override // v1.w0
    public final void n0(SurfaceView surfaceView) {
        D0();
        this.f7038v.n0(surfaceView);
    }

    @Override // v1.w0
    public final long o() {
        D0();
        return this.f7038v.o();
    }

    @Override // v1.w0
    public final void o0(int i, int i10) {
        D0();
        this.f7038v.o0(i, i10);
    }

    @Override // v1.w0
    public final long p() {
        D0();
        return this.f7038v.p();
    }

    @Override // v1.w0
    public final void p0(int i, int i10, int i11) {
        D0();
        this.f7038v.p0(i, i10, i11);
    }

    @Override // v1.w0
    public final long q() {
        D0();
        return this.f7038v.q();
    }

    @Override // v1.w0
    public final boolean q0() {
        D0();
        return this.f7038v.q0();
    }

    @Override // v1.w0
    public final long r() {
        D0();
        return this.f7038v.r();
    }

    @Override // v1.w0
    public final int r0() {
        D0();
        return this.f7038v.r0();
    }

    @Override // v1.w0
    public final void s(int i, long j4) {
        D0();
        this.f7038v.s(i, j4);
    }

    @Override // v1.w0
    public final void s0(int i, int i10, List list) {
        D0();
        this.f7038v.s0(i, i10, list);
    }

    @Override // v1.w0
    public final void stop() {
        D0();
        this.f7038v.stop();
    }

    @Override // v1.w0
    public final void t(int i, List list) {
        D0();
        this.f7038v.t(i, list);
    }

    @Override // v1.w0
    public final void t0(List list) {
        D0();
        this.f7038v.t0(list);
    }

    @Override // v1.w0
    public final v1.s0 u() {
        D0();
        return this.f7038v.u();
    }

    @Override // v1.w0
    public final int u0() {
        D0();
        return this.f7038v.u0();
    }

    @Override // v1.w0
    public final long v() {
        D0();
        return this.f7038v.v();
    }

    @Override // v1.w0
    public final v1.f1 v0() {
        D0();
        return this.f7038v.v0();
    }

    @Override // v1.w0
    public final boolean w() {
        D0();
        return this.f7038v.w();
    }

    @Override // v1.w0
    public final boolean w0() {
        D0();
        return this.f7038v.w0();
    }

    @Override // v1.w0
    public final boolean x() {
        D0();
        return this.f7038v.x();
    }

    @Override // v1.w0
    public final void x0(v1.c cVar, boolean z10) {
        this.f7038v.x0(cVar, z10);
    }

    @Override // v1.w0
    public final void y() {
        D0();
        this.f7038v.y();
    }

    @Override // v1.w0
    public final Looper y0() {
        return this.f7038v.y0();
    }

    @Override // v1.w0
    public final v1.g0 z() {
        D0();
        return this.f7038v.z();
    }

    @Override // v1.w0
    public final void z0(int i) {
        D0();
        this.f7038v.z0(i);
    }
}

package q4;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Runnable {
    public final /* synthetic */ RecyclerView A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10953u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10954v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OverScroller f10955w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Interpolator f10956x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10957y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10958z;

    public w0(RecyclerView recyclerView) {
        this.A = recyclerView;
        k5.b bVar = RecyclerView.f1641c1;
        this.f10956x = bVar;
        this.f10957y = false;
        this.f10958z = false;
        this.f10955w = new OverScroller(recyclerView.getContext(), bVar);
    }

    public final void a(int i, int i10) {
        RecyclerView recyclerView = this.A;
        recyclerView.setScrollState(2);
        this.f10954v = 0;
        this.f10953u = 0;
        Interpolator interpolator = this.f10956x;
        k5.b bVar = RecyclerView.f1641c1;
        if (interpolator != bVar) {
            this.f10956x = bVar;
            this.f10955w = new OverScroller(recyclerView.getContext(), bVar);
        }
        this.f10955w.fling(0, 0, i, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.f10957y) {
            this.f10958z = true;
            return;
        }
        RecyclerView recyclerView = this.A;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = q0.o0.f10475a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i, int i10, int i11, Interpolator interpolator) {
        RecyclerView recyclerView = this.A;
        if (i11 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i10);
            boolean z2 = iAbs > iAbs2;
            int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z2) {
                iAbs = iAbs2;
            }
            i11 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i12 = i11;
        if (interpolator == null) {
            interpolator = RecyclerView.f1641c1;
        }
        if (this.f10956x != interpolator) {
            this.f10956x = interpolator;
            this.f10955w = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f10954v = 0;
        this.f10953u = 0;
        recyclerView.setScrollState(2);
        this.f10955w.startScroll(0, 0, i, i10, i12);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i10;
        int i11;
        int i12;
        RecyclerView recyclerView = this.A;
        int[] iArr = recyclerView.M0;
        if (recyclerView.H == null) {
            recyclerView.removeCallbacks(this);
            this.f10955w.abortAnimation();
            return;
        }
        this.f10958z = false;
        this.f10957y = true;
        recyclerView.p();
        OverScroller overScroller = this.f10955w;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i13 = currX - this.f10953u;
            int i14 = currY - this.f10954v;
            this.f10953u = currX;
            this.f10954v = currY;
            int iO = RecyclerView.o(i13, recyclerView.f1647e0, recyclerView.f1649g0, recyclerView.getWidth());
            int iO2 = RecyclerView.o(i14, recyclerView.f1648f0, recyclerView.f1650h0, recyclerView.getHeight());
            int[] iArr2 = recyclerView.M0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.u(iO, iO2, 1, iArr2, null)) {
                iO -= iArr[0];
                iO2 -= iArr[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.n(iO, iO2);
            }
            if (recyclerView.G != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.f0(iO, iO2, iArr);
                int i15 = iArr[0];
                int i16 = iArr[1];
                int i17 = iO - i15;
                int i18 = iO2 - i16;
                t tVar = recyclerView.H.f10821e;
                if (tVar != null && !tVar.f10924d && tVar.f10925e) {
                    int iB = recyclerView.A0.b();
                    if (iB == 0) {
                        tVar.i();
                    } else if (tVar.f10921a >= iB) {
                        tVar.f10921a = iB - 1;
                        tVar.g(i15, i16);
                    } else {
                        tVar.g(i15, i16);
                    }
                }
                i = i17;
                i11 = i15;
                i10 = i18;
                i12 = i16;
            } else {
                i = iO;
                i10 = iO2;
                i11 = 0;
                i12 = 0;
            }
            if (!recyclerView.J.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.M0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.v(i11, i12, i, i10, null, 1, iArr3);
            int i19 = i - iArr[0];
            int i20 = i10 - iArr[1];
            if (i11 != 0 || i12 != 0) {
                recyclerView.w(i11, i12);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i19 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i20 != 0));
            t tVar2 = recyclerView.H.f10821e;
            if ((tVar2 == null || !tVar2.f10924d) && z2) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i21 = i19 < 0 ? -currVelocity : i19 > 0 ? currVelocity : 0;
                    if (i20 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i20 <= 0) {
                        currVelocity = 0;
                    }
                    if (i21 < 0) {
                        recyclerView.y();
                        if (recyclerView.f1647e0.isFinished()) {
                            recyclerView.f1647e0.onAbsorb(-i21);
                        }
                    } else if (i21 > 0) {
                        recyclerView.z();
                        if (recyclerView.f1649g0.isFinished()) {
                            recyclerView.f1649g0.onAbsorb(i21);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.A();
                        if (recyclerView.f1648f0.isFinished()) {
                            recyclerView.f1648f0.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.x();
                        if (recyclerView.f1650h0.isFinished()) {
                            recyclerView.f1650h0.onAbsorb(currVelocity);
                        }
                    }
                    if (i21 != 0 || currVelocity != 0) {
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.a1) {
                    k kVar = recyclerView.f1673z0;
                    int[] iArr4 = kVar.f10859a;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    kVar.f10862d = 0;
                }
            } else {
                b();
                m mVar = recyclerView.f1671y0;
                if (mVar != null) {
                    mVar.a(recyclerView, i11, i12);
                }
            }
            if (Build.VERSION.SDK_INT >= 35) {
                b0.a(recyclerView, Math.abs(overScroller.getCurrVelocity()));
            }
        }
        t tVar3 = recyclerView.H.f10821e;
        if (tVar3 != null && tVar3.f10924d) {
            tVar3.g(0, 0);
        }
        this.f10957y = false;
        if (!this.f10958z) {
            recyclerView.setScrollState(0);
            recyclerView.n0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = q0.o0.f10475a;
            recyclerView.postOnAnimation(this);
        }
    }
}

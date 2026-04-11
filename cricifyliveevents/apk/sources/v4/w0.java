package v4;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Runnable {
    public boolean A;
    public final /* synthetic */ RecyclerView B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13380v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13381w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OverScroller f13382x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Interpolator f13383y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13384z;

    public w0(RecyclerView recyclerView) {
        this.B = recyclerView;
        b1.d dVar = RecyclerView.f1425d1;
        this.f13383y = dVar;
        this.f13384z = false;
        this.A = false;
        this.f13382x = new OverScroller(recyclerView.getContext(), dVar);
    }

    public final void a(int i, int i10) {
        RecyclerView recyclerView = this.B;
        recyclerView.setScrollState(2);
        this.f13381w = 0;
        this.f13380v = 0;
        Interpolator interpolator = this.f13383y;
        b1.d dVar = RecyclerView.f1425d1;
        if (interpolator != dVar) {
            this.f13383y = dVar;
            this.f13382x = new OverScroller(recyclerView.getContext(), dVar);
        }
        this.f13382x.fling(0, 0, i, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.f13384z) {
            this.A = true;
            return;
        }
        RecyclerView recyclerView = this.B;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = t0.m0.f11777a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i, int i10, int i11, Interpolator interpolator) {
        RecyclerView recyclerView = this.B;
        if (i11 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i10);
            boolean z10 = iAbs > iAbs2;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                iAbs = iAbs2;
            }
            i11 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i12 = i11;
        if (interpolator == null) {
            interpolator = RecyclerView.f1425d1;
        }
        if (this.f13383y != interpolator) {
            this.f13383y = interpolator;
            this.f13382x = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f13381w = 0;
        this.f13380v = 0;
        recyclerView.setScrollState(2);
        this.f13382x.startScroll(0, 0, i, i10, i12);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i10;
        int i11;
        int i12;
        RecyclerView recyclerView = this.B;
        int[] iArr = recyclerView.N0;
        if (recyclerView.I == null) {
            recyclerView.removeCallbacks(this);
            this.f13382x.abortAnimation();
            return;
        }
        this.A = false;
        this.f13384z = true;
        recyclerView.p();
        OverScroller overScroller = this.f13382x;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i13 = currX - this.f13380v;
            int i14 = currY - this.f13381w;
            this.f13380v = currX;
            this.f13381w = currY;
            int iO = RecyclerView.o(i13, recyclerView.f1432f0, recyclerView.f1434h0, recyclerView.getWidth());
            int iO2 = RecyclerView.o(i14, recyclerView.f1433g0, recyclerView.f1435i0, recyclerView.getHeight());
            int[] iArr2 = recyclerView.N0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.u(iO, iO2, 1, iArr2, null)) {
                iO -= iArr[0];
                iO2 -= iArr[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.n(iO, iO2);
            }
            if (recyclerView.H != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.f0(iO, iO2, iArr);
                int i15 = iArr[0];
                int i16 = iArr[1];
                int i17 = iO - i15;
                int i18 = iO2 - i16;
                s sVar = recyclerView.I.f13251e;
                if (sVar != null && !sVar.f13349d && sVar.f13350e) {
                    int iB = recyclerView.B0.b();
                    if (iB == 0) {
                        sVar.i();
                    } else if (sVar.f13346a >= iB) {
                        sVar.f13346a = iB - 1;
                        sVar.g(i15, i16);
                    } else {
                        sVar.g(i15, i16);
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
            if (!recyclerView.K.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.N0;
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
            boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i19 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i20 != 0));
            s sVar2 = recyclerView.I.f13251e;
            if ((sVar2 == null || !sVar2.f13349d) && z10) {
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
                        if (recyclerView.f1432f0.isFinished()) {
                            recyclerView.f1432f0.onAbsorb(-i21);
                        }
                    } else if (i21 > 0) {
                        recyclerView.z();
                        if (recyclerView.f1434h0.isFinished()) {
                            recyclerView.f1434h0.onAbsorb(i21);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.A();
                        if (recyclerView.f1433g0.isFinished()) {
                            recyclerView.f1433g0.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.x();
                        if (recyclerView.f1435i0.isFinished()) {
                            recyclerView.f1435i0.onAbsorb(currVelocity);
                        }
                    }
                    if (i21 != 0 || currVelocity != 0) {
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.f1424b1) {
                    v.g gVar = recyclerView.A0;
                    int[] iArr4 = gVar.f12526c;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    gVar.f12527d = 0;
                }
            } else {
                b();
                l lVar = recyclerView.f1456z0;
                if (lVar != null) {
                    lVar.a(recyclerView, i11, i12);
                }
            }
            if (Build.VERSION.SDK_INT >= 35) {
                b0.a(recyclerView, Math.abs(overScroller.getCurrVelocity()));
            }
        }
        s sVar3 = recyclerView.I.f13251e;
        if (sVar3 != null && sVar3.f13349d) {
            sVar3.g(0, 0);
        }
        this.f13384z = false;
        if (!this.A) {
            recyclerView.setScrollState(0);
            recyclerView.n0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = t0.m0.f11777a;
            recyclerView.postOnAnimation(this);
        }
    }
}

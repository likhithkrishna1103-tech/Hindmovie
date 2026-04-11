package g4;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5107e;

    public l1() {
        this.f5103a = 0;
        this.f5106d = new Object();
        this.f5107e = new s.e(0);
    }

    public void a(int i) {
        int i10 = this.f5103a;
        Object obj = this.f5106d;
        Object obj2 = this.f5107e;
        switch (i10) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj2;
                WeakReference weakReference = sideSheetBehavior.J;
                if (weakReference != null && weakReference.get() != null) {
                    this.f5104b = i;
                    if (!this.f5105c) {
                        WeakHashMap weakHashMap = q0.o0.f10475a;
                        ((View) sideSheetBehavior.J.get()).postOnAnimation((nc.b) obj);
                        this.f5105c = true;
                    }
                    break;
                }
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj2;
                WeakReference weakReference2 = bottomSheetBehavior.f3349o0;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f5104b = i;
                    if (!this.f5105c) {
                        WeakHashMap weakHashMap2 = q0.o0.f10475a;
                        ((View) bottomSheetBehavior.f3349o0.get()).postOnAnimation((androidx.fragment.app.e) obj);
                        this.f5105c = true;
                    }
                    break;
                }
                break;
        }
    }

    public k1 b(Object obj) {
        k1 k1Var;
        synchronized (this.f5106d) {
            try {
                int iC = c();
                k1Var = new k1(iC, obj);
                if (this.f5105c) {
                    k1Var.m();
                } else {
                    ((s.e) this.f5107e).put(Integer.valueOf(iC), k1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return k1Var;
    }

    public int c() {
        int i;
        synchronized (this.f5106d) {
            i = this.f5104b;
            this.f5104b = i + 1;
        }
        return i;
    }

    public void d() {
        ArrayList arrayList;
        synchronized (this.f5106d) {
            this.f5105c = true;
            arrayList = new ArrayList(((s.e) this.f5107e).values());
            ((s.e) this.f5107e).clear();
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((k1) obj).m();
        }
    }

    public void e(int i, q1 q1Var) {
        synchronized (this.f5106d) {
            try {
                k1 k1Var = (k1) ((s.e) this.f5107e).remove(Integer.valueOf(i));
                if (k1Var != null) {
                    if (k1Var.C.getClass() == q1.class) {
                        k1Var.k(q1Var);
                    } else {
                        s1.b.p("SequencedFutureManager", "Type mismatch, expected " + k1Var.C.getClass() + ", but was " + q1.class);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public l1(SideSheetBehavior sideSheetBehavior) {
        this.f5103a = 1;
        this.f5107e = sideSheetBehavior;
        this.f5106d = new nc.b(3, this);
    }

    public l1(BottomSheetBehavior bottomSheetBehavior) {
        this.f5103a = 2;
        this.f5107e = bottomSheetBehavior;
        this.f5106d = new androidx.fragment.app.e(27, this);
    }
}

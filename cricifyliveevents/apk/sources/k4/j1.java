package k4;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f7050e;

    public j1() {
        this.f7046a = 0;
        this.f7049d = new Object();
        this.f7050e = new v.e(0);
    }

    public void a(int i) {
        switch (this.f7046a) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f7050e;
                WeakReference weakReference = sideSheetBehavior.K;
                if (weakReference != null && weakReference.get() != null) {
                    this.f7047b = i;
                    if (!this.f7048c) {
                        ((View) sideSheetBehavior.K.get()).postOnAnimation((androidx.emoji2.text.w) this.f7049d);
                        this.f7048c = true;
                    }
                    break;
                }
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f7050e;
                WeakReference weakReference2 = bottomSheetBehavior.f2805r0;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f7047b = i;
                    if (!this.f7048c) {
                        ((View) bottomSheetBehavior.f2805r0.get()).postOnAnimation((androidx.fragment.app.m) this.f7049d);
                        this.f7048c = true;
                    }
                    break;
                }
                break;
        }
    }

    public i1 b(Object obj) {
        i1 i1Var;
        synchronized (this.f7049d) {
            try {
                int iC = c();
                i1Var = new i1(iC, obj);
                if (this.f7048c) {
                    i1Var.m();
                } else {
                    ((v.e) this.f7050e).put(Integer.valueOf(iC), i1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i1Var;
    }

    public int c() {
        int i;
        synchronized (this.f7049d) {
            i = this.f7047b;
            this.f7047b = i + 1;
        }
        return i;
    }

    public void d() {
        ArrayList arrayList;
        synchronized (this.f7049d) {
            this.f7048c = true;
            arrayList = new ArrayList(((v.e) this.f7050e).values());
            ((v.e) this.f7050e).clear();
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((i1) obj).m();
        }
    }

    public void e(int i, o1 o1Var) {
        synchronized (this.f7049d) {
            try {
                i1 i1Var = (i1) ((v.e) this.f7050e).remove(Integer.valueOf(i));
                if (i1Var != null) {
                    if (i1Var.D.getClass() == o1.class) {
                        i1Var.k(o1Var);
                    } else {
                        y1.b.p("SequencedFutureManager", "Type mismatch, expected " + i1Var.D.getClass() + ", but was " + o1.class);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j1(SideSheetBehavior sideSheetBehavior) {
        this.f7046a = 1;
        this.f7050e = sideSheetBehavior;
        this.f7049d = new androidx.emoji2.text.w(22, this);
    }

    public j1(BottomSheetBehavior bottomSheetBehavior) {
        this.f7046a = 2;
        this.f7050e = bottomSheetBehavior;
        this.f7049d = new androidx.fragment.app.m(26, this);
    }
}

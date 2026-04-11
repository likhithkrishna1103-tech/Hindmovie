package q4;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final List f10961t = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f10962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f10963b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10969j;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f10977r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z f10978s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10964c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10965d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10966e = -1;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10967g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x0 f10968h = null;
    public x0 i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f10970k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f10971l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10972m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n0 f10973n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10974o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10975p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10976q = -1;

    public x0(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f10962a = view;
    }

    public final void a(int i) {
        this.f10969j = i | this.f10969j;
    }

    public final int b() {
        int i = this.f10967g;
        return i == -1 ? this.f10964c : i;
    }

    public final List c() {
        ArrayList arrayList;
        return ((this.f10969j & 1024) != 0 || (arrayList = this.f10970k) == null || arrayList.size() == 0) ? f10961t : this.f10971l;
    }

    public final boolean d() {
        View view = this.f10962a;
        return (view.getParent() == null || view.getParent() == this.f10977r) ? false : true;
    }

    public final boolean e() {
        return (this.f10969j & 1) != 0;
    }

    public final boolean f() {
        return (this.f10969j & 4) != 0;
    }

    public final boolean g() {
        if ((this.f10969j & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = q0.o0.f10475a;
        return !this.f10962a.hasTransientState();
    }

    public final boolean h() {
        return (this.f10969j & 8) != 0;
    }

    public final boolean i() {
        return this.f10973n != null;
    }

    public final boolean j() {
        return (this.f10969j & 256) != 0;
    }

    public final boolean k() {
        return (this.f10969j & 2) != 0;
    }

    public final void l(int i, boolean z2) {
        if (this.f10965d == -1) {
            this.f10965d = this.f10964c;
        }
        if (this.f10967g == -1) {
            this.f10967g = this.f10964c;
        }
        if (z2) {
            this.f10967g += i;
        }
        this.f10964c += i;
        View view = this.f10962a;
        if (view.getLayoutParams() != null) {
            ((i0) view.getLayoutParams()).f10833c = true;
        }
    }

    public final void m() {
        if (RecyclerView.V0 && j()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.f10969j = 0;
        this.f10964c = -1;
        this.f10965d = -1;
        this.f10966e = -1L;
        this.f10967g = -1;
        this.f10972m = 0;
        this.f10968h = null;
        this.i = null;
        ArrayList arrayList = this.f10970k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f10969j &= -1025;
        this.f10975p = 0;
        this.f10976q = -1;
        RecyclerView.l(this);
    }

    public final void n(boolean z2) {
        int i = this.f10972m;
        int i10 = z2 ? i - 1 : i + 1;
        this.f10972m = i10;
        if (i10 < 0) {
            this.f10972m = 0;
            if (RecyclerView.V0) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z2 && i10 == 1) {
            this.f10969j |= 16;
        } else if (z2 && i10 == 0) {
            this.f10969j &= -17;
        }
        if (RecyclerView.W0) {
            Log.d("RecyclerView", "setIsRecyclable val:" + z2 + ":" + this);
        }
    }

    public final boolean o() {
        return (this.f10969j & 128) != 0;
    }

    public final boolean p() {
        return (this.f10969j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f10964c + " id=" + this.f10966e + ", oldPos=" + this.f10965d + ", pLpos:" + this.f10967g);
        if (i()) {
            sb2.append(" scrap ");
            sb2.append(this.f10974o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (f()) {
            sb2.append(" invalid");
        }
        if (!e()) {
            sb2.append(" unbound");
        }
        if ((this.f10969j & 2) != 0) {
            sb2.append(" update");
        }
        if (h()) {
            sb2.append(" removed");
        }
        if (o()) {
            sb2.append(" ignored");
        }
        if (j()) {
            sb2.append(" tmpDetached");
        }
        if (!g()) {
            sb2.append(" not recyclable(" + this.f10972m + ")");
        }
        if ((this.f10969j & 512) != 0 || f()) {
            sb2.append(" undefined adapter position");
        }
        if (this.f10962a.getParent() == null) {
            sb2.append(" no parent");
        }
        sb2.append("}");
        return sb2.toString();
    }
}

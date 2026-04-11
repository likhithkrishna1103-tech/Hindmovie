package v4;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final List f13386t = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f13387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f13388b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13394j;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f13402r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z f13403s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13389c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13390d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13391e = -1;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13392g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x0 f13393h = null;
    public x0 i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f13395k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f13396l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13397m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n0 f13398n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13399o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13400p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13401q = -1;

    public x0(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f13387a = view;
    }

    public final void a(int i) {
        this.f13394j = i | this.f13394j;
    }

    public final int b() {
        int i = this.f13392g;
        return i == -1 ? this.f13389c : i;
    }

    public final List c() {
        ArrayList arrayList;
        return ((this.f13394j & 1024) != 0 || (arrayList = this.f13395k) == null || arrayList.size() == 0) ? f13386t : this.f13396l;
    }

    public final boolean d() {
        View view = this.f13387a;
        return (view.getParent() == null || view.getParent() == this.f13402r) ? false : true;
    }

    public final boolean e() {
        return (this.f13394j & 1) != 0;
    }

    public final boolean f() {
        return (this.f13394j & 4) != 0;
    }

    public final boolean g() {
        if ((this.f13394j & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = t0.m0.f11777a;
        return !this.f13387a.hasTransientState();
    }

    public final boolean h() {
        return (this.f13394j & 8) != 0;
    }

    public final boolean i() {
        return this.f13398n != null;
    }

    public final boolean j() {
        return (this.f13394j & 256) != 0;
    }

    public final boolean k() {
        return (this.f13394j & 2) != 0;
    }

    public final void l(int i, boolean z10) {
        if (this.f13390d == -1) {
            this.f13390d = this.f13389c;
        }
        if (this.f13392g == -1) {
            this.f13392g = this.f13389c;
        }
        if (z10) {
            this.f13392g += i;
        }
        this.f13389c += i;
        View view = this.f13387a;
        if (view.getLayoutParams() != null) {
            ((i0) view.getLayoutParams()).f13263c = true;
        }
    }

    public final void m() {
        if (RecyclerView.W0 && j()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.f13394j = 0;
        this.f13389c = -1;
        this.f13390d = -1;
        this.f13391e = -1L;
        this.f13392g = -1;
        this.f13397m = 0;
        this.f13393h = null;
        this.i = null;
        ArrayList arrayList = this.f13395k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f13394j &= -1025;
        this.f13400p = 0;
        this.f13401q = -1;
        RecyclerView.l(this);
    }

    public final void n(boolean z10) {
        int i = this.f13397m;
        int i10 = z10 ? i - 1 : i + 1;
        this.f13397m = i10;
        if (i10 < 0) {
            this.f13397m = 0;
            if (RecyclerView.W0) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z10 && i10 == 1) {
            this.f13394j |= 16;
        } else if (z10 && i10 == 0) {
            this.f13394j &= -17;
        }
        if (RecyclerView.X0) {
            Log.d("RecyclerView", "setIsRecyclable val:" + z10 + ":" + this);
        }
    }

    public final boolean o() {
        return (this.f13394j & 128) != 0;
    }

    public final boolean p() {
        return (this.f13394j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f13389c + " id=" + this.f13391e + ", oldPos=" + this.f13390d + ", pLpos:" + this.f13392g);
        if (i()) {
            sb.append(" scrap ");
            sb.append(this.f13399o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (f()) {
            sb.append(" invalid");
        }
        if (!e()) {
            sb.append(" unbound");
        }
        if ((this.f13394j & 2) != 0) {
            sb.append(" update");
        }
        if (h()) {
            sb.append(" removed");
        }
        if (o()) {
            sb.append(" ignored");
        }
        if (j()) {
            sb.append(" tmpDetached");
        }
        if (!g()) {
            sb.append(" not recyclable(" + this.f13397m + ")");
        }
        if ((this.f13394j & 512) != 0 || f()) {
            sb.append(" undefined adapter position");
        }
        if (this.f13387a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}

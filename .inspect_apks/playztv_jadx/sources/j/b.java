package j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.StateSet;
import s.g;
import s.h;
import s.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable.ConstantState {
    public boolean A;
    public ColorFilter B;
    public boolean C;
    public ColorStateList D;
    public PorterDuff.Mode E;
    public boolean F;
    public boolean G;
    public int[][] H;
    public g I;
    public j J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources f6620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6623e;
    public SparseArray f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable[] f6624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6625h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f6627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6631o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6632p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6633q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6634r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6635s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6636t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6637u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6638v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6639w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6640x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6641y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6642z;

    public b(b bVar, e eVar, Resources resources) {
        this.i = false;
        this.f6628l = false;
        this.f6639w = true;
        this.f6641y = 0;
        this.f6642z = 0;
        this.f6619a = eVar;
        this.f6620b = resources != null ? resources : bVar != null ? bVar.f6620b : null;
        int i = bVar != null ? bVar.f6621c : 0;
        int i10 = e.N;
        i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
        i = i == 0 ? 160 : i;
        this.f6621c = i;
        if (bVar != null) {
            this.f6622d = bVar.f6622d;
            this.f6623e = bVar.f6623e;
            this.f6637u = true;
            this.f6638v = true;
            this.i = bVar.i;
            this.f6628l = bVar.f6628l;
            this.f6639w = bVar.f6639w;
            this.f6640x = bVar.f6640x;
            this.f6641y = bVar.f6641y;
            this.f6642z = bVar.f6642z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            if (bVar.f6621c == i) {
                if (bVar.f6626j) {
                    this.f6627k = bVar.f6627k != null ? new Rect(bVar.f6627k) : null;
                    this.f6626j = true;
                }
                if (bVar.f6629m) {
                    this.f6630n = bVar.f6630n;
                    this.f6631o = bVar.f6631o;
                    this.f6632p = bVar.f6632p;
                    this.f6633q = bVar.f6633q;
                    this.f6629m = true;
                }
            }
            if (bVar.f6634r) {
                this.f6635s = bVar.f6635s;
                this.f6634r = true;
            }
            if (bVar.f6636t) {
                this.f6636t = true;
            }
            Drawable[] drawableArr = bVar.f6624g;
            this.f6624g = new Drawable[drawableArr.length];
            this.f6625h = bVar.f6625h;
            SparseArray sparseArray = bVar.f;
            if (sparseArray != null) {
                this.f = sparseArray.clone();
            } else {
                this.f = new SparseArray(this.f6625h);
            }
            int i11 = this.f6625h;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f.put(i12, constantState);
                    } else {
                        this.f6624g[i12] = drawableArr[i12];
                    }
                }
            }
        } else {
            this.f6624g = new Drawable[10];
            this.f6625h = 0;
        }
        if (bVar != null) {
            this.H = bVar.H;
        } else {
            this.H = new int[this.f6624g.length][];
        }
        if (bVar != null) {
            this.I = bVar.I;
            this.J = bVar.J;
        } else {
            this.I = new g();
            this.J = new j();
        }
    }

    public final int a(Drawable drawable) {
        int i = this.f6625h;
        if (i >= this.f6624g.length) {
            int i10 = i + 10;
            Drawable[] drawableArr = new Drawable[i10];
            Drawable[] drawableArr2 = this.f6624g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.f6624g = drawableArr;
            int[][] iArr = new int[i10][];
            System.arraycopy(this.H, 0, iArr, 0, i);
            this.H = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f6619a);
        this.f6624g[i] = drawable;
        this.f6625h++;
        this.f6623e = drawable.getChangingConfigurations() | this.f6623e;
        this.f6634r = false;
        this.f6636t = false;
        this.f6627k = null;
        this.f6626j = false;
        this.f6629m = false;
        this.f6637u = false;
        return i;
    }

    public final void b() {
        this.f6629m = true;
        c();
        int i = this.f6625h;
        Drawable[] drawableArr = this.f6624g;
        this.f6631o = -1;
        this.f6630n = -1;
        this.f6633q = 0;
        this.f6632p = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Drawable drawable = drawableArr[i10];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f6630n) {
                this.f6630n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f6631o) {
                this.f6631o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f6632p) {
                this.f6632p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f6633q) {
                this.f6633q = minimumHeight;
            }
        }
    }

    public final void c() {
        SparseArray sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = this.f.keyAt(i);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.valueAt(i);
                Drawable[] drawableArr = this.f6624g;
                Drawable drawableNewDrawable = constantState.newDrawable(this.f6620b);
                drawableNewDrawable.setLayoutDirection(this.f6640x);
                Drawable drawableMutate = drawableNewDrawable.mutate();
                drawableMutate.setCallback(this.f6619a);
                drawableArr[iKeyAt] = drawableMutate;
            }
            this.f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i = this.f6625h;
        Drawable[] drawableArr = this.f6624g;
        for (int i10 = 0; i10 < i; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.get(i10);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (drawable.canApplyTheme()) {
                return true;
            }
        }
        return false;
    }

    public final Drawable d(int i) {
        int iIndexOfKey;
        Drawable drawable = this.f6624g[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f.valueAt(iIndexOfKey)).newDrawable(this.f6620b);
        drawableNewDrawable.setLayoutDirection(this.f6640x);
        Drawable drawableMutate = drawableNewDrawable.mutate();
        drawableMutate.setCallback(this.f6619a);
        this.f6624g[i] = drawableMutate;
        this.f.removeAt(iIndexOfKey);
        if (this.f.size() == 0) {
            this.f = null;
        }
        return drawableMutate;
    }

    public final int e(int i) {
        Object obj;
        if (i < 0) {
            return 0;
        }
        j jVar = this.J;
        Object obj2 = 0;
        int iA = t.a.a(jVar.f11638w, i, jVar.f11636u);
        if (iA >= 0 && (obj = jVar.f11637v[iA]) != h.f11632b) {
            obj2 = obj;
        }
        return ((Integer) obj2).intValue();
    }

    public final int f(int[] iArr) {
        int[][] iArr2 = this.H;
        int i = this.f6625h;
        for (int i10 = 0; i10 < i; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f6622d | this.f6623e;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new e(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new e(this, resources);
    }
}

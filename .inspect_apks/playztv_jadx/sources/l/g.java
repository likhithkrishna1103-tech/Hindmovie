package l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import m.n;
import m.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ h E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Menu f7767a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7773h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7774j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f7775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f7776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7777m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public char f7778n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7779o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public char f7780p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7781q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7782r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7783s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7784t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7785u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7786v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7787w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7788x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7789y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n f7790z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7768b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7769c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7770d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7771e = 0;
    public boolean f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7772g = true;

    public g(h hVar, Menu menu) {
        this.E = hVar;
        this.f7767a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f7794c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        h hVar = this.E;
        Context context = hVar.f7794c;
        boolean z2 = false;
        menuItem.setChecked(this.f7783s).setVisible(this.f7784t).setEnabled(this.f7785u).setCheckable(this.f7782r >= 1).setTitleCondensed(this.f7776l).setIcon(this.f7777m);
        int i = this.f7786v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.f7789y != null) {
            if (context.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (hVar.f7795d == null) {
                hVar.f7795d = h.a(context);
            }
            Object obj = hVar.f7795d;
            String str = this.f7789y;
            f fVar = new f();
            fVar.f7765a = obj;
            Class<?> cls = obj.getClass();
            try {
                fVar.f7766b = cls.getMethod(str, f.f7764c);
                menuItem.setOnMenuItemClickListener(fVar);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }
        if (this.f7782r >= 2) {
            if (menuItem instanceof m.m) {
                ((m.m) menuItem).f(true);
            } else if (menuItem instanceof r) {
                r rVar = (r) menuItem;
                k0.a aVar = rVar.f8261c;
                try {
                    if (rVar.f8262d == null) {
                        rVar.f8262d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    rVar.f8262d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e11) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
                }
            }
        }
        String str2 = this.f7788x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, h.f7791e, hVar.f7792a));
            z2 = true;
        }
        int i10 = this.f7787w;
        if (i10 > 0) {
            if (z2) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i10);
            }
        }
        n nVar = this.f7790z;
        if (nVar != null) {
            if (menuItem instanceof k0.a) {
                ((k0.a) menuItem).b(nVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z10 = menuItem instanceof k0.a;
        if (z10) {
            ((k0.a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            j0.a.e(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z10) {
            ((k0.a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            j0.a.i(menuItem, charSequence2);
        }
        char c9 = this.f7778n;
        int i11 = this.f7779o;
        if (z10) {
            ((k0.a) menuItem).setAlphabeticShortcut(c9, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            j0.a.d(menuItem, c9, i11);
        }
        char c10 = this.f7780p;
        int i12 = this.f7781q;
        if (z10) {
            ((k0.a) menuItem).setNumericShortcut(c10, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            j0.a.h(menuItem, c10, i12);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z10) {
                ((k0.a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                j0.a.g(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z10) {
                ((k0.a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                j0.a.f(menuItem, colorStateList);
            }
        }
    }
}

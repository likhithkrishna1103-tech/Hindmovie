package m;

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
import n.n;
import n.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ h E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Menu f7981a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7987h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f7989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f7990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public char f7992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7993o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public char f7994p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7995q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7996r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7997s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7998t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7999u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8000v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8001w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f8002x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f8003y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n f8004z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7982b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7983c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7984d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7985e = 0;
    public boolean f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7986g = true;

    public g(h hVar, Menu menu) {
        this.E = hVar;
        this.f7981a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f8008c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e9) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e9);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        h hVar = this.E;
        Context context = hVar.f8008c;
        boolean z10 = false;
        menuItem.setChecked(this.f7997s).setVisible(this.f7998t).setEnabled(this.f7999u).setCheckable(this.f7996r >= 1).setTitleCondensed(this.f7990l).setIcon(this.f7991m);
        int i = this.f8000v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.f8003y != null) {
            if (context.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (hVar.f8009d == null) {
                hVar.f8009d = h.a(context);
            }
            Object obj = hVar.f8009d;
            String str = this.f8003y;
            f fVar = new f();
            fVar.f7979a = obj;
            Class<?> cls = obj.getClass();
            try {
                fVar.f7980b = cls.getMethod(str, f.f7978c);
                menuItem.setOnMenuItemClickListener(fVar);
            } catch (Exception e9) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e9);
                throw inflateException;
            }
        }
        if (this.f7996r >= 2) {
            if (menuItem instanceof n.m) {
                ((n.m) menuItem).f(true);
            } else if (menuItem instanceof r) {
                r rVar = (r) menuItem;
                n0.a aVar = rVar.f8575c;
                try {
                    if (rVar.f8576d == null) {
                        rVar.f8576d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    rVar.f8576d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e10) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
                }
            }
        }
        String str2 = this.f8002x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, h.f8005e, hVar.f8006a));
            z10 = true;
        }
        int i10 = this.f8001w;
        if (i10 > 0) {
            if (z10) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i10);
            }
        }
        n nVar = this.f8004z;
        if (nVar != null) {
            if (menuItem instanceof n0.a) {
                ((n0.a) menuItem).b(nVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z11 = menuItem instanceof n0.a;
        if (z11) {
            ((n0.a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            d1.a.f(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z11) {
            ((n0.a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            d1.a.j(menuItem, charSequence2);
        }
        char c9 = this.f7992n;
        int i11 = this.f7993o;
        if (z11) {
            ((n0.a) menuItem).setAlphabeticShortcut(c9, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            d1.a.e(menuItem, c9, i11);
        }
        char c10 = this.f7994p;
        int i12 = this.f7995q;
        if (z11) {
            ((n0.a) menuItem).setNumericShortcut(c10, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            d1.a.i(menuItem, c10, i12);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z11) {
                ((n0.a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                d1.a.h(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z11) {
                ((n0.a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                d1.a.g(menuItem, colorStateList);
            }
        }
    }
}

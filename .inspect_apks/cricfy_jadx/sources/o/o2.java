package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o2 {
    public static o2 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f9292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v.k f9293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v.l f9294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f9295d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f9296e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c2.o f9297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f9290h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m2 f9291j = new m2(6);

    public static synchronized o2 d() {
        try {
            if (i == null) {
                o2 o2Var = new o2();
                i = o2Var;
                j(o2Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public static synchronized PorterDuffColorFilter h(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        m2 m2Var = f9291j;
        m2Var.getClass();
        int i11 = (31 + i10) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) m2Var.h(Integer.valueOf(mode.hashCode() + i11));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
        }
        return porterDuffColorFilter;
    }

    public static void j(o2 o2Var) {
        if (Build.VERSION.SDK_INT < 24) {
            o2Var.a("vector", new n2(3));
            o2Var.a("animated-vector", new n2(2));
            o2Var.a("animated-selector", new n2(1));
            o2Var.a("drawable", new n2(0));
        }
    }

    public final void a(String str, n2 n2Var) {
        if (this.f9293b == null) {
            this.f9293b = new v.k(0);
        }
        this.f9293b.put(str, n2Var);
    }

    public final synchronized void b(Context context, long j4, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                v.h hVar = (v.h) this.f9295d.get(context);
                if (hVar == null) {
                    hVar = new v.h();
                    this.f9295d.put(context, hVar);
                }
                hVar.h(j4, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable c(Context context, int i10) {
        if (this.f9296e == null) {
            this.f9296e = new TypedValue();
        }
        TypedValue typedValue = this.f9296e;
        context.getResources().getValue(i10, typedValue, true);
        long j4 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j4);
        if (drawableE != null) {
            return drawableE;
        }
        LayerDrawable layerDrawableN = null;
        if (this.f9297g != null) {
            if (i10 == g.e.abc_cab_background_top_material) {
                layerDrawableN = new LayerDrawable(new Drawable[]{f(context, g.e.abc_cab_background_internal_bg), f(context, g.e.abc_cab_background_top_mtrl_alpha)});
            } else if (i10 == g.e.abc_ratingbar_material) {
                layerDrawableN = c2.o.n(this, context, g.d.abc_star_big);
            } else if (i10 == g.e.abc_ratingbar_indicator_material) {
                layerDrawableN = c2.o.n(this, context, g.d.abc_star_medium);
            } else if (i10 == g.e.abc_ratingbar_small_material) {
                layerDrawableN = c2.o.n(this, context, g.d.abc_star_small);
            }
        }
        if (layerDrawableN != null) {
            layerDrawableN.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j4, layerDrawableN);
        }
        return layerDrawableN;
    }

    public final synchronized Drawable e(Context context, long j4) {
        v.h hVar = (v.h) this.f9295d.get(context);
        if (hVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) hVar.d(j4);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iB = w.a.b(hVar.f12529w, hVar.f12531y, j4);
            if (iB >= 0) {
                Object[] objArr = hVar.f12530x;
                Object obj = objArr[iB];
                Object obj2 = v.i.f12532a;
                if (obj != obj2) {
                    objArr[iB] = obj2;
                    hVar.f12528v = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable f(Context context, int i10) {
        return g(context, i10, false);
    }

    public final synchronized Drawable g(Context context, int i10, boolean z10) {
        Drawable drawableK;
        try {
            if (!this.f) {
                this.f = true;
                Drawable drawableF = f(context, k.b.abc_vector_test);
                if (drawableF == null || (!(drawableF instanceof m5.o) && !"android.graphics.drawable.VectorDrawable".equals(drawableF.getClass().getName()))) {
                    this.f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableK = k(context, i10);
            if (drawableK == null) {
                drawableK = c(context, i10);
            }
            if (drawableK == null) {
                drawableK = context.getDrawable(i10);
            }
            if (drawableK != null) {
                drawableK = n(context, i10, z10, drawableK);
            }
            if (drawableK != null) {
                n1.a(drawableK);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableK;
    }

    public final synchronized ColorStateList i(Context context, int i10) {
        ColorStateList colorStateList;
        v.l lVar;
        WeakHashMap weakHashMap = this.f9292a;
        ColorStateList colorStateListP = null;
        colorStateList = (weakHashMap == null || (lVar = (v.l) weakHashMap.get(context)) == null) ? null : (ColorStateList) lVar.c(i10);
        if (colorStateList == null) {
            c2.o oVar = this.f9297g;
            if (oVar != null) {
                colorStateListP = oVar.p(context, i10);
            }
            if (colorStateListP != null) {
                if (this.f9292a == null) {
                    this.f9292a = new WeakHashMap();
                }
                v.l lVar2 = (v.l) this.f9292a.get(context);
                if (lVar2 == null) {
                    lVar2 = new v.l();
                    this.f9292a.put(context, lVar2);
                }
                lVar2.a(i10, colorStateListP);
            }
            colorStateList = colorStateListP;
        }
        return colorStateList;
    }

    public final Drawable k(Context context, int i10) {
        int next;
        v.k kVar = this.f9293b;
        if (kVar == null || kVar.isEmpty()) {
            return null;
        }
        v.l lVar = this.f9294c;
        if (lVar != null) {
            String str = (String) lVar.c(i10);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.f9293b.get(str) == null) {
                return null;
            }
        } else {
            this.f9294c = new v.l();
        }
        if (this.f9296e == null) {
            this.f9296e = new TypedValue();
        }
        TypedValue typedValue = this.f9296e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long j4 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j4);
        if (drawableE != null) {
            return drawableE;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f9294c.a(i10, name);
                n2 n2Var = (n2) this.f9293b.get(name);
                if (n2Var != null) {
                    drawableE = n2Var.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableE != null) {
                    drawableE.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j4, drawableE);
                }
            } catch (Exception e9) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e9);
            }
        }
        if (drawableE == null) {
            this.f9294c.a(i10, "appcompat_skip_skip");
        }
        return drawableE;
    }

    public final synchronized void l(Context context) {
        v.h hVar = (v.h) this.f9295d.get(context);
        if (hVar != null) {
            hVar.b();
        }
    }

    public final synchronized void m(c2.o oVar) {
        this.f9297g = oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable n(android.content.Context r8, int r9, boolean r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.o2.n(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}

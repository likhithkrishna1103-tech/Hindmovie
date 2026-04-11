package n;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n2 {
    public static n2 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f8462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s.i f8463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s.j f8464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f8465d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f8466e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b2.g f8467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f8460h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l2 f8461j = new l2(6);

    public static synchronized n2 d() {
        try {
            if (i == null) {
                n2 n2Var = new n2();
                i = n2Var;
                j(n2Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public static synchronized PorterDuffColorFilter h(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        l2 l2Var = f8461j;
        l2Var.getClass();
        int i11 = (31 + i10) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) l2Var.g(Integer.valueOf(mode.hashCode() + i11));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
        }
        return porterDuffColorFilter;
    }

    public static void j(n2 n2Var) {
        if (Build.VERSION.SDK_INT < 24) {
            n2Var.a("vector", new m2(3));
            n2Var.a("animated-vector", new m2(2));
            n2Var.a("animated-selector", new m2(1));
            n2Var.a("drawable", new m2(0));
        }
    }

    public final void a(String str, m2 m2Var) {
        if (this.f8463b == null) {
            this.f8463b = new s.i(0);
        }
        this.f8463b.put(str, m2Var);
    }

    public final synchronized void b(Context context, long j5, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                s.g gVar = (s.g) this.f8465d.get(context);
                if (gVar == null) {
                    gVar = new s.g();
                    this.f8465d.put(context, gVar);
                }
                gVar.h(j5, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable c(Context context, int i10) {
        if (this.f8466e == null) {
            this.f8466e = new TypedValue();
        }
        TypedValue typedValue = this.f8466e;
        context.getResources().getValue(i10, typedValue, true);
        long j5 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j5);
        if (drawableE != null) {
            return drawableE;
        }
        LayerDrawable layerDrawableM = null;
        if (this.f8467g != null) {
            if (i10 == g.e.abc_cab_background_top_material) {
                layerDrawableM = new LayerDrawable(new Drawable[]{f(context, g.e.abc_cab_background_internal_bg), f(context, g.e.abc_cab_background_top_mtrl_alpha)});
            } else if (i10 == g.e.abc_ratingbar_material) {
                layerDrawableM = b2.g.m(this, context, g.d.abc_star_big);
            } else if (i10 == g.e.abc_ratingbar_indicator_material) {
                layerDrawableM = b2.g.m(this, context, g.d.abc_star_medium);
            } else if (i10 == g.e.abc_ratingbar_small_material) {
                layerDrawableM = b2.g.m(this, context, g.d.abc_star_small);
            }
        }
        if (layerDrawableM != null) {
            layerDrawableM.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j5, layerDrawableM);
        }
        return layerDrawableM;
    }

    public final synchronized Drawable e(Context context, long j5) {
        s.g gVar = (s.g) this.f8465d.get(context);
        if (gVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) gVar.d(j5);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iB = t.a.b(gVar.f11628v, gVar.f11630x, j5);
            if (iB >= 0) {
                Object[] objArr = gVar.f11629w;
                Object obj = objArr[iB];
                Object obj2 = s.h.f11631a;
                if (obj != obj2) {
                    objArr[iB] = obj2;
                    gVar.f11627u = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable f(Context context, int i10) {
        return g(context, i10, false);
    }

    public final synchronized Drawable g(Context context, int i10, boolean z2) {
        Drawable drawableK;
        try {
            if (!this.f) {
                this.f = true;
                Drawable drawableF = f(context, k.b.abc_vector_test);
                if (drawableF == null || (!(drawableF instanceof h5.r) && !"android.graphics.drawable.VectorDrawable".equals(drawableF.getClass().getName()))) {
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
                drawableK = n(context, i10, z2, drawableK);
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
        s.j jVar;
        WeakHashMap weakHashMap = this.f8462a;
        ColorStateList colorStateListO = null;
        colorStateList = (weakHashMap == null || (jVar = (s.j) weakHashMap.get(context)) == null) ? null : (ColorStateList) jVar.c(i10);
        if (colorStateList == null) {
            b2.g gVar = this.f8467g;
            if (gVar != null) {
                colorStateListO = gVar.o(context, i10);
            }
            if (colorStateListO != null) {
                if (this.f8462a == null) {
                    this.f8462a = new WeakHashMap();
                }
                s.j jVar2 = (s.j) this.f8462a.get(context);
                if (jVar2 == null) {
                    jVar2 = new s.j();
                    this.f8462a.put(context, jVar2);
                }
                jVar2.a(i10, colorStateListO);
            }
            colorStateList = colorStateListO;
        }
        return colorStateList;
    }

    public final Drawable k(Context context, int i10) {
        int next;
        s.i iVar = this.f8463b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        s.j jVar = this.f8464c;
        if (jVar != null) {
            String str = (String) jVar.c(i10);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.f8463b.get(str) == null) {
                return null;
            }
        } else {
            this.f8464c = new s.j();
        }
        if (this.f8466e == null) {
            this.f8466e = new TypedValue();
        }
        TypedValue typedValue = this.f8466e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long j5 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j5);
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
                this.f8464c.a(i10, name);
                m2 m2Var = (m2) this.f8463b.get(name);
                if (m2Var != null) {
                    drawableE = m2Var.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableE != null) {
                    drawableE.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j5, drawableE);
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (drawableE == null) {
            this.f8464c.a(i10, "appcompat_skip_skip");
        }
        return drawableE;
    }

    public final synchronized void l(Context context) {
        s.g gVar = (s.g) this.f8465d.get(context);
        if (gVar != null) {
            gVar.b();
        }
    }

    public final synchronized void m(b2.g gVar) {
        this.f8467g = gVar;
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
        throw new UnsupportedOperationException("Method not decompiled: n.n2.n(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}

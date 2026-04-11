package h;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import o.i1;
import o.p3;
import o.x3;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends p implements n.i, LayoutInflater.Factory2 {
    public static final v.k C0 = new v.k(0);
    public static final int[] D0 = {R.attr.windowBackground};
    public static final boolean E0 = !"robolectric".equals(Build.FINGERPRINT);
    public OnBackInvokedDispatcher A0;
    public OnBackInvokedCallback B0;
    public final Object E;
    public final Context F;
    public Window G;
    public w H;
    public final Object I;
    public vf.g J;
    public m.h K;
    public CharSequence L;
    public i1 M;
    public p6.d N;
    public r O;
    public m.a P;
    public ActionBarContextView Q;
    public PopupWindow R;
    public q S;
    public boolean U;
    public ViewGroup V;
    public TextView W;
    public View X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f5262a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f5263b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f5264c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f5265d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f5266e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f5267f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public z[] f5268g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public z f5269h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f5270i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f5271j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f5272k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f5273l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public Configuration f5274m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final int f5275n0;
    public int o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f5276p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f5277q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public x f5278r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public x f5279s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f5280t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f5281u0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f5283w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public Rect f5284x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public Rect f5285y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public e0 f5286z0;
    public q0 T = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final q f5282v0 = new q(this, 0);

    public a0(Context context, Window window, k kVar, Object obj) {
        j jVar = null;
        this.f5275n0 = -100;
        this.F = context;
        this.I = kVar;
        this.E = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof j)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        jVar = (j) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (jVar != null) {
                this.f5275n0 = ((a0) jVar.m()).f5275n0;
            }
        }
        if (this.f5275n0 == -100) {
            String name = this.E.getClass().getName();
            v.k kVar2 = C0;
            Integer num = (Integer) kVar2.get(name);
            if (num != null) {
                this.f5275n0 = num.intValue();
                kVar2.remove(this.E.getClass().getName());
            }
        }
        if (window != null) {
            n(window);
        }
        o.r.d();
    }

    public static p0.g B(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? u.b(configuration) : p0.g.b(t.b(configuration.locale));
    }

    public static p0.g o(Context context) {
        p0.g gVar;
        p0.g gVarB;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (gVar = p.f5396x) == null) {
            return null;
        }
        p0.i iVar = gVar.f9874a;
        p0.g gVarB2 = B(context.getApplicationContext().getResources().getConfiguration());
        int i10 = 0;
        if (i < 24) {
            gVarB = iVar.isEmpty() ? p0.g.f9873b : p0.g.b(t.b(iVar.get(0)));
        } else if (iVar.isEmpty()) {
            gVarB = p0.g.f9873b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i10 < gVarB2.f9874a.size() + iVar.size()) {
                Locale locale = i10 < iVar.size() ? iVar.get(i10) : gVarB2.f9874a.get(i10 - iVar.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i10++;
            }
            gVarB = p0.g.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return gVarB.f9874a.isEmpty() ? gVarB2 : gVarB;
    }

    public static Configuration s(Context context, int i, p0.g gVar, Configuration configuration, boolean z10) {
        int i10 = i != 1 ? i != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i10 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            p0.i iVar = gVar.f9874a;
            if (Build.VERSION.SDK_INT >= 24) {
                u.d(configuration2, gVar);
                return configuration2;
            }
            configuration2.setLocale(iVar.get(0));
            configuration2.setLayoutDirection(iVar.get(0));
        }
        return configuration2;
    }

    public final androidx.fragment.app.h A(Context context) {
        if (this.f5278r0 == null) {
            if (androidx.emoji2.text.v.A == null) {
                Context applicationContext = context.getApplicationContext();
                androidx.emoji2.text.v.A = new androidx.emoji2.text.v(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f5278r0 = new x(this, androidx.emoji2.text.v.A);
        }
        return this.f5278r0;
    }

    public final z C(int i) {
        z[] zVarArr = this.f5268g0;
        if (zVarArr == null || zVarArr.length <= i) {
            z[] zVarArr2 = new z[i + 1];
            if (zVarArr != null) {
                System.arraycopy(zVarArr, 0, zVarArr2, 0, zVarArr.length);
            }
            this.f5268g0 = zVarArr2;
            zVarArr = zVarArr2;
        }
        z zVar = zVarArr[i];
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z();
        zVar2.f5411a = i;
        zVar2.f5422n = false;
        zVarArr[i] = zVar2;
        return zVar2;
    }

    public final void D() {
        v();
        if (this.f5262a0 && this.J == null) {
            Object obj = this.E;
            if (obj instanceof Activity) {
                this.J = new m0((Activity) obj, this.f5263b0);
            } else if (obj instanceof Dialog) {
                this.J = new m0((Dialog) obj);
            }
            vf.g gVar = this.J;
            if (gVar != null) {
                gVar.S(this.f5283w0);
            }
        }
    }

    public final void E(int i) {
        this.f5281u0 = (1 << i) | this.f5281u0;
        if (this.f5280t0) {
            return;
        }
        View decorView = this.G.getDecorView();
        WeakHashMap weakHashMap = t0.m0.f11777a;
        decorView.postOnAnimation(this.f5282v0);
        this.f5280t0 = true;
    }

    public final int F(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.f5279s0 == null) {
                            this.f5279s0 = new x(this, context);
                        }
                        return this.f5279s0.f();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return A(context).f();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean G() {
        boolean z10 = this.f5270i0;
        this.f5270i0 = false;
        z zVarC = C(0);
        if (!zVarC.f5421m) {
            m.a aVar = this.P;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            D();
            vf.g gVar = this.J;
            if (gVar == null || !gVar.m()) {
                return false;
            }
        } else if (!z10) {
            r(zVarC, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0164, code lost:
    
        if (r15.B.getCount() > 0) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(h.z r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.H(h.z, android.view.KeyEvent):void");
    }

    public final boolean I(z zVar, int i, KeyEvent keyEvent) {
        n.k kVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((zVar.f5419k || J(zVar, keyEvent)) && (kVar = zVar.f5417h) != null) {
            return kVar.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean J(h.z r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.J(h.z, android.view.KeyEvent):boolean");
    }

    public final void K() {
        if (this.U) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void L() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z10 = false;
            if (this.A0 != null && (C(0).f5421m || this.P != null)) {
                z10 = true;
            }
            if (z10 && this.B0 == null) {
                this.B0 = v.b(this.A0, this);
            } else {
                if (z10 || (onBackInvokedCallback = this.B0) == null) {
                    return;
                }
                v.c(this.A0, onBackInvokedCallback);
                this.B0 = null;
            }
        }
    }

    @Override // h.p
    public final void a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.F);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof a0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // h.p
    public final void b() {
        if (this.J != null) {
            D();
            if (this.J.I()) {
                return;
            }
            E(0);
        }
    }

    @Override // h.p
    public final void d() throws IllegalAccessException {
        String strC;
        this.f5271j0 = true;
        m(false, true);
        w();
        Object obj = this.E;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strC = h0.c.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e9) {
                    throw new IllegalArgumentException(e9);
                }
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                vf.g gVar = this.J;
                if (gVar == null) {
                    this.f5283w0 = true;
                } else {
                    gVar.S(true);
                }
            }
            synchronized (p.C) {
                p.f(this);
                p.B.add(new WeakReference(this));
            }
        }
        this.f5274m0 = new Configuration(this.F.getResources().getConfiguration());
        this.f5272k0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // h.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.E
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = h.p.C
            monitor-enter(r0)
            h.p.f(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f5280t0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.G
            android.view.View r0 = r0.getDecorView()
            h.q r1 = r3.f5282v0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f5273l0 = r0
            int r0 = r3.f5275n0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.E
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            v.k r0 = h.a0.C0
            java.lang.Object r1 = r3.E
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f5275n0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            v.k r0 = h.a0.C0
            java.lang.Object r1 = r3.E
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            vf.g r0 = r3.J
            if (r0 == 0) goto L63
            r0.K()
        L63:
            h.x r0 = r3.f5278r0
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            h.x r0 = r3.f5279s0
            if (r0 == 0) goto L71
            r0.c()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.e():void");
    }

    @Override // h.p
    public final boolean g(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.f5266e0 && i == 108) {
            return false;
        }
        if (this.f5262a0 && i == 1) {
            this.f5262a0 = false;
        }
        if (i == 1) {
            K();
            this.f5266e0 = true;
            return true;
        }
        if (i == 2) {
            K();
            this.Y = true;
            return true;
        }
        if (i == 5) {
            K();
            this.Z = true;
            return true;
        }
        if (i == 10) {
            K();
            this.f5264c0 = true;
            return true;
        }
        if (i == 108) {
            K();
            this.f5262a0 = true;
            return true;
        }
        if (i != 109) {
            return this.G.requestFeature(i);
        }
        K();
        this.f5263b0 = true;
        return true;
    }

    @Override // h.p
    public final void h(int i) {
        v();
        ViewGroup viewGroup = (ViewGroup) this.V.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.F).inflate(i, viewGroup);
        this.H.a(this.G.getCallback());
    }

    @Override // h.p
    public final void i(View view) {
        v();
        ViewGroup viewGroup = (ViewGroup) this.V.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.H.a(this.G.getCallback());
    }

    @Override // h.p
    public final void j(View view, ViewGroup.LayoutParams layoutParams) {
        v();
        ViewGroup viewGroup = (ViewGroup) this.V.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.H.a(this.G.getCallback());
    }

    @Override // h.p
    public final void l(CharSequence charSequence) {
        this.L = charSequence;
        i1 i1Var = this.M;
        if (i1Var != null) {
            i1Var.setWindowTitle(charSequence);
            return;
        }
        vf.g gVar = this.J;
        if (gVar != null) {
            gVar.W(charSequence);
            return;
        }
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(boolean r17, boolean r18) throws java.lang.IllegalAccessException {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.m(boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(android.view.Window r4) {
        /*
            r3 = this;
            android.view.Window r0 = r3.G
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L66
            android.view.Window$Callback r0 = r4.getCallback()
            boolean r2 = r0 instanceof h.w
            if (r2 != 0) goto L60
            h.w r1 = new h.w
            r1.<init>(r3, r0)
            r3.H = r1
            r4.setCallback(r1)
            android.content.Context r0 = r3.F
            int[] r1 = h.a0.D0
            r2 = 0
            l7.a r0 = l7.a.E(r0, r2, r1)
            r1 = 0
            android.graphics.drawable.Drawable r1 = r0.v(r1)
            if (r1 == 0) goto L2b
            r4.setBackgroundDrawable(r1)
        L2b:
            r0.G()
            r3.G = r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r4 < r0) goto L5f
            android.window.OnBackInvokedDispatcher r4 = r3.A0
            if (r4 != 0) goto L5f
            if (r4 == 0) goto L45
            android.window.OnBackInvokedCallback r0 = r3.B0
            if (r0 == 0) goto L45
            h.v.c(r4, r0)
            r3.B0 = r2
        L45:
            java.lang.Object r4 = r3.E
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L5a
            android.app.Activity r4 = (android.app.Activity) r4
            android.view.Window r0 = r4.getWindow()
            if (r0 == 0) goto L5a
            android.window.OnBackInvokedDispatcher r4 = h.v.a(r4)
            r3.A0 = r4
            goto L5c
        L5a:
            r3.A0 = r2
        L5c:
            r3.L()
        L5f:
            return
        L60:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r1)
            throw r4
        L66:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.n(android.view.Window):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:118:0x01e7
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void p(int i, z zVar, n.k kVar) {
        if (kVar == null) {
            if (zVar == null && i >= 0) {
                z[] zVarArr = this.f5268g0;
                if (i < zVarArr.length) {
                    zVar = zVarArr[i];
                }
            }
            if (zVar != null) {
                kVar = zVar.f5417h;
            }
        }
        if ((zVar == null || zVar.f5421m) && !this.f5273l0) {
            w wVar = this.H;
            Window.Callback callback = this.G.getCallback();
            wVar.getClass();
            try {
                wVar.f5407z = true;
                callback.onPanelClosed(i, kVar);
            } finally {
                wVar.f5407z = false;
            }
        }
    }

    public final void q(n.k kVar) {
        o.k kVar2;
        if (this.f5267f0) {
            return;
        }
        this.f5267f0 = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.M;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((p3) actionBarOverlayLayout.f542z).f9308a.f619v;
        if (actionMenuView != null && (kVar2 = actionMenuView.O) != null) {
            kVar2.d();
            o.f fVar = kVar2.P;
            if (fVar != null && fVar.b()) {
                fVar.i.dismiss();
            }
        }
        Window.Callback callback = this.G.getCallback();
        if (callback != null && !this.f5273l0) {
            callback.onPanelClosed(108, kVar);
        }
        this.f5267f0 = false;
    }

    public final void r(z zVar, boolean z10) {
        y yVar;
        i1 i1Var;
        if (z10 && zVar.f5411a == 0 && (i1Var = this.M) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) i1Var;
            actionBarOverlayLayout.k();
            if (((p3) actionBarOverlayLayout.f542z).f9308a.o()) {
                q(zVar.f5417h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.F.getSystemService("window");
        if (windowManager != null && zVar.f5421m && (yVar = zVar.f5415e) != null) {
            windowManager.removeView(yVar);
            if (z10) {
                p(zVar.f5411a, zVar, null);
            }
        }
        zVar.f5419k = false;
        zVar.f5420l = false;
        zVar.f5421m = false;
        zVar.f = null;
        zVar.f5422n = true;
        if (this.f5269h0 == zVar) {
            this.f5269h0 = null;
        }
        if (zVar.f5411a == 0) {
            L();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.t(android.view.KeyEvent):boolean");
    }

    public final void u(int i) {
        z zVarC = C(i);
        if (zVarC.f5417h != null) {
            Bundle bundle = new Bundle();
            zVarC.f5417h.t(bundle);
            if (bundle.size() > 0) {
                zVarC.f5424p = bundle;
            }
            zVarC.f5417h.w();
            zVarC.f5417h.clear();
        }
        zVarC.f5423o = true;
        zVarC.f5422n = true;
        if ((i == 108 || i == 0) && this.M != null) {
            z zVarC2 = C(0);
            zVarC2.f5419k = false;
            J(zVarC2, null);
        }
    }

    public final void v() {
        ViewGroup viewGroup;
        if (this.U) {
            return;
        }
        int[] iArr = g.j.AppCompatTheme;
        Context context = this.F;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowNoTitle, false)) {
            g(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowActionBar, false)) {
            g(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowActionBarOverlay, false)) {
            g(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowActionModeOverlay, false)) {
            g(10);
        }
        this.f5265d0 = typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        w();
        this.G.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f5266e0) {
            viewGroup = this.f5264c0 ? (ViewGroup) layoutInflaterFrom.inflate(g.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(g.g.abc_screen_simple, (ViewGroup) null);
        } else if (this.f5265d0) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(g.g.abc_dialog_title_material, (ViewGroup) null);
            this.f5263b0 = false;
            this.f5262a0 = false;
        } else if (this.f5262a0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(g.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new m.c(context, typedValue.resourceId) : context).inflate(g.g.abc_screen_toolbar, (ViewGroup) null);
            i1 i1Var = (i1) viewGroup.findViewById(g.f.decor_content_parent);
            this.M = i1Var;
            i1Var.setWindowCallback(this.G.getCallback());
            if (this.f5263b0) {
                ((ActionBarOverlayLayout) this.M).j(109);
            }
            if (this.Y) {
                ((ActionBarOverlayLayout) this.M).j(2);
            }
            if (this.Z) {
                ((ActionBarOverlayLayout) this.M).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f5262a0 + ", windowActionBarOverlay: " + this.f5263b0 + ", android:windowIsFloating: " + this.f5265d0 + ", windowActionModeOverlay: " + this.f5264c0 + ", windowNoTitle: " + this.f5266e0 + " }");
        }
        r rVar = new r(this);
        WeakHashMap weakHashMap = t0.m0.f11777a;
        t0.d0.l(viewGroup, rVar);
        if (this.M == null) {
            this.W = (TextView) viewGroup.findViewById(g.f.title);
        }
        boolean z10 = x3.f9407a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e9) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e9);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(g.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.G.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.G.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new p6.c(18, this));
        this.V = viewGroup;
        Object obj = this.E;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.L;
        if (!TextUtils.isEmpty(title)) {
            i1 i1Var2 = this.M;
            if (i1Var2 != null) {
                i1Var2.setWindowTitle(title);
            } else {
                vf.g gVar = this.J;
                if (gVar != null) {
                    gVar.W(title);
                } else {
                    TextView textView = this.W;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.V.findViewById(R.id.content);
        View decorView = this.G.getDecorView();
        contentFrameLayout2.B.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(g.j.AppCompatTheme);
        typedArrayObtainStyledAttributes2.getValue(g.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(g.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(g.j.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes2.getValue(g.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(g.j.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes2.getValue(g.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(g.j.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes2.getValue(g.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(g.j.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes2.getValue(g.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.U = true;
        z zVarC = C(0);
        if (this.f5273l0 || zVarC.f5417h != null) {
            return;
        }
        E(108);
    }

    public final void w() {
        if (this.G == null) {
            Object obj = this.E;
            if (obj instanceof Activity) {
                n(((Activity) obj).getWindow());
            }
        }
        if (this.G == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // n.i
    public final boolean x(n.k kVar, MenuItem menuItem) {
        z zVar;
        Window.Callback callback = this.G.getCallback();
        if (callback != null && !this.f5273l0) {
            n.k kVarK = kVar.k();
            z[] zVarArr = this.f5268g0;
            int length = zVarArr != null ? zVarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    zVar = zVarArr[i];
                    if (zVar != null && zVar.f5417h == kVarK) {
                        break;
                    }
                    i++;
                } else {
                    zVar = null;
                    break;
                }
            }
            if (zVar != null) {
                return callback.onMenuItemSelected(zVar.f5411a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.f() != false) goto L20;
     */
    @Override // n.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(n.k r6) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a0.y(n.k):void");
    }

    public final Context z() {
        D();
        vf.g gVar = this.J;
        Context contextH = gVar != null ? gVar.H() : null;
        return contextH == null ? this.F : contextH;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}

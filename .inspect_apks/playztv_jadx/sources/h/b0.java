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
import n.l1;
import n.m3;
import n.u3;
import q0.o0;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends q implements m.i, LayoutInflater.Factory2 {
    public static final s.i C0 = new s.i(0);
    public static final int[] D0 = {R.attr.windowBackground};
    public static final boolean E0 = !"robolectric".equals(Build.FINGERPRINT);
    public OnBackInvokedDispatcher A0;
    public OnBackInvokedCallback B0;
    public final Object D;
    public final Context E;
    public Window F;
    public x G;
    public final Object H;
    public com.bumptech.glide.d I;
    public l.h J;
    public CharSequence K;
    public l1 L;
    public wb.c M;
    public rc.b N;
    public l.a O;
    public ActionBarContextView P;
    public PopupWindow Q;
    public r R;
    public boolean U;
    public ViewGroup V;
    public TextView W;
    public View X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f5415a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f5416b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f5417c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f5418d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f5419e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f5420f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public a0[] f5421g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public a0 f5422h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f5423i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f5424j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f5425k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public Configuration f5426m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final int f5427n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f5428o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f5429p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f5430q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public y f5431r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public y f5432s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f5433t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f5434u0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f5436w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public Rect f5437x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public Rect f5438y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public f0 f5439z0;
    public t0 S = null;
    public final boolean T = true;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final r f5435v0 = new r(this, 0);

    public b0(Context context, Window window, k kVar, Object obj) {
        j jVar = null;
        this.f5427n0 = -100;
        this.E = context;
        this.H = kVar;
        this.D = obj;
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
                this.f5427n0 = ((b0) jVar.m()).f5427n0;
            }
        }
        if (this.f5427n0 == -100) {
            String name = this.D.getClass().getName();
            s.i iVar = C0;
            Integer num = (Integer) iVar.get(name);
            if (num != null) {
                this.f5427n0 = num.intValue();
                iVar.remove(this.D.getClass().getName());
            }
        }
        if (window != null) {
            o(window);
        }
        n.t.d();
    }

    public static m0.g B(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? u.b(configuration) : m0.g.b(t.b(configuration.locale));
    }

    public static m0.g p(Context context) {
        m0.g gVar;
        m0.g gVarB;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (gVar = q.f5552w) == null) {
            return null;
        }
        m0.i iVar = gVar.f8282a;
        m0.g gVarB2 = B(context.getApplicationContext().getResources().getConfiguration());
        int i10 = 0;
        if (i < 24) {
            gVarB = iVar.isEmpty() ? m0.g.f8281b : m0.g.b(t.b(iVar.get(0)));
        } else if (iVar.isEmpty()) {
            gVarB = m0.g.f8281b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i10 < gVarB2.f8282a.size() + iVar.size()) {
                Locale locale = i10 < iVar.size() ? iVar.get(i10) : gVarB2.f8282a.get(i10 - iVar.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i10++;
            }
            gVarB = m0.g.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return gVarB.f8282a.isEmpty() ? gVarB2 : gVarB;
    }

    public static Configuration u(Context context, int i, m0.g gVar, Configuration configuration, boolean z2) {
        int i10 = i != 1 ? i != 2 ? z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i10 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            m0.i iVar = gVar.f8282a;
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
        if (this.f5431r0 == null) {
            if (a7.b.f616y == null) {
                Context applicationContext = context.getApplicationContext();
                a7.b.f616y = new a7.b(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f5431r0 = new y(this, a7.b.f616y);
        }
        return this.f5431r0;
    }

    public final a0 C(int i) {
        a0[] a0VarArr = this.f5421g0;
        if (a0VarArr == null || a0VarArr.length <= i) {
            a0[] a0VarArr2 = new a0[i + 1];
            if (a0VarArr != null) {
                System.arraycopy(a0VarArr, 0, a0VarArr2, 0, a0VarArr.length);
            }
            this.f5421g0 = a0VarArr2;
            a0VarArr = a0VarArr2;
        }
        a0 a0Var = a0VarArr[i];
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0Var2 = new a0();
        a0Var2.f5399a = i;
        a0Var2.f5410n = false;
        a0VarArr[i] = a0Var2;
        return a0Var2;
    }

    public final void D() {
        x();
        if (this.f5415a0 && this.I == null) {
            Object obj = this.D;
            if (obj instanceof Activity) {
                this.I = new n0((Activity) obj, this.f5416b0);
            } else if (obj instanceof Dialog) {
                this.I = new n0((Dialog) obj);
            }
            com.bumptech.glide.d dVar = this.I;
            if (dVar != null) {
                dVar.I(this.f5436w0);
            }
        }
    }

    public final void E(int i) {
        this.f5434u0 = (1 << i) | this.f5434u0;
        if (this.f5433t0) {
            return;
        }
        View decorView = this.F.getDecorView();
        WeakHashMap weakHashMap = o0.f10475a;
        decorView.postOnAnimation(this.f5435v0);
        this.f5433t0 = true;
    }

    public final int F(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.f5432s0 == null) {
                            this.f5432s0 = new y(this, context);
                        }
                        return this.f5432s0.f();
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
        boolean z2 = this.f5423i0;
        this.f5423i0 = false;
        a0 a0VarC = C(0);
        if (!a0VarC.f5409m) {
            l.a aVar = this.O;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            D();
            com.bumptech.glide.d dVar = this.I;
            if (dVar == null || !dVar.g()) {
                return false;
            }
        } else if (!z2) {
            t(a0VarC, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0166, code lost:
    
        if (r15.A.getCount() > 0) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(h.a0 r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b0.H(h.a0, android.view.KeyEvent):void");
    }

    public final boolean I(a0 a0Var, int i, KeyEvent keyEvent) {
        m.k kVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((a0Var.f5407k || J(a0Var, keyEvent)) && (kVar = a0Var.f5405h) != null) {
            return kVar.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean J(h.a0 r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b0.J(h.a0, android.view.KeyEvent):boolean");
    }

    public final void K() {
        if (this.U) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void L() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z2 = false;
            if (this.A0 != null && (C(0).f5409m || this.O != null)) {
                z2 = true;
            }
            if (z2 && this.B0 == null) {
                this.B0 = w.b(this.A0, this);
            } else {
                if (z2 || (onBackInvokedCallback = this.B0) == null) {
                    return;
                }
                w.c(this.A0, onBackInvokedCallback);
                this.B0 = null;
            }
        }
    }

    @Override // h.q
    public final void a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.E);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof b0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // h.q
    public final void b() {
        if (this.I != null) {
            D();
            if (this.I.v()) {
                return;
            }
            E(0);
        }
    }

    @Override // h.q
    public final void d() throws IllegalAccessException {
        String strC;
        this.f5424j0 = true;
        n(false, true);
        y();
        Object obj = this.D;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strC = e0.c.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e10) {
                    throw new IllegalArgumentException(e10);
                }
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                com.bumptech.glide.d dVar = this.I;
                if (dVar == null) {
                    this.f5436w0 = true;
                } else {
                    dVar.I(true);
                }
            }
            synchronized (q.B) {
                q.f(this);
                q.A.add(new WeakReference(this));
            }
        }
        this.f5426m0 = new Configuration(this.E.getResources().getConfiguration());
        this.f5425k0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // h.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.D
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = h.q.B
            monitor-enter(r0)
            h.q.f(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f5433t0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.F
            android.view.View r0 = r0.getDecorView()
            h.r r1 = r3.f5435v0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.l0 = r0
            int r0 = r3.f5427n0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.D
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            s.i r0 = h.b0.C0
            java.lang.Object r1 = r3.D
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f5427n0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            s.i r0 = h.b0.C0
            java.lang.Object r1 = r3.D
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            com.bumptech.glide.d r0 = r3.I
            if (r0 == 0) goto L63
            r0.y()
        L63:
            h.y r0 = r3.f5431r0
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            h.y r0 = r3.f5432s0
            if (r0 == 0) goto L71
            r0.c()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b0.e():void");
    }

    @Override // m.i
    public final boolean g(m.k kVar, MenuItem menuItem) {
        a0 a0Var;
        Window.Callback callback = this.F.getCallback();
        if (callback != null && !this.l0) {
            m.k kVarK = kVar.k();
            a0[] a0VarArr = this.f5421g0;
            int length = a0VarArr != null ? a0VarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    a0Var = a0VarArr[i];
                    if (a0Var != null && a0Var.f5405h == kVarK) {
                        break;
                    }
                    i++;
                } else {
                    a0Var = null;
                    break;
                }
            }
            if (a0Var != null) {
                return callback.onMenuItemSelected(a0Var.f5399a, menuItem);
            }
        }
        return false;
    }

    @Override // h.q
    public final boolean h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.f5419e0 && i == 108) {
            return false;
        }
        if (this.f5415a0 && i == 1) {
            this.f5415a0 = false;
        }
        if (i == 1) {
            K();
            this.f5419e0 = true;
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
            this.f5417c0 = true;
            return true;
        }
        if (i == 108) {
            K();
            this.f5415a0 = true;
            return true;
        }
        if (i != 109) {
            return this.F.requestFeature(i);
        }
        K();
        this.f5416b0 = true;
        return true;
    }

    @Override // h.q
    public final void i(int i) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.V.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.E).inflate(i, viewGroup);
        this.G.a(this.F.getCallback());
    }

    @Override // h.q
    public final void j(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.V.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.G.a(this.F.getCallback());
    }

    @Override // h.q
    public final void k(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.V.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.G.a(this.F.getCallback());
    }

    @Override // h.q
    public final void m(CharSequence charSequence) {
        this.K = charSequence;
        l1 l1Var = this.L;
        if (l1Var != null) {
            l1Var.setWindowTitle(charSequence);
            return;
        }
        com.bumptech.glide.d dVar = this.I;
        if (dVar != null) {
            dVar.Q(charSequence);
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
    public final boolean n(boolean r17, boolean r18) throws java.lang.IllegalAccessException {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b0.n(boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(android.view.Window r4) {
        /*
            r3 = this;
            android.view.Window r0 = r3.F
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L66
            android.view.Window$Callback r0 = r4.getCallback()
            boolean r2 = r0 instanceof h.x
            if (r2 != 0) goto L60
            h.x r1 = new h.x
            r1.<init>(r3, r0)
            r3.G = r1
            r4.setCallback(r1)
            android.content.Context r0 = r3.E
            int[] r1 = h.b0.D0
            r2 = 0
            kc.b r0 = kc.b.C(r0, r2, r1)
            r1 = 0
            android.graphics.drawable.Drawable r1 = r0.t(r1)
            if (r1 == 0) goto L2b
            r4.setBackgroundDrawable(r1)
        L2b:
            r0.E()
            r3.F = r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r4 < r0) goto L5f
            android.window.OnBackInvokedDispatcher r4 = r3.A0
            if (r4 != 0) goto L5f
            if (r4 == 0) goto L45
            android.window.OnBackInvokedCallback r0 = r3.B0
            if (r0 == 0) goto L45
            h.w.c(r4, r0)
            r3.B0 = r2
        L45:
            java.lang.Object r4 = r3.D
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L5a
            android.app.Activity r4 = (android.app.Activity) r4
            android.view.Window r0 = r4.getWindow()
            if (r0 == 0) goto L5a
            android.window.OnBackInvokedDispatcher r4 = h.w.a(r4)
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
        throw new UnsupportedOperationException("Method not decompiled: h.b0.o(android.view.Window):void");
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
        throw new UnsupportedOperationException("Method not decompiled: h.b0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void q(int i, a0 a0Var, m.k kVar) {
        if (kVar == null) {
            if (a0Var == null && i >= 0) {
                a0[] a0VarArr = this.f5421g0;
                if (i < a0VarArr.length) {
                    a0Var = a0VarArr[i];
                }
            }
            if (a0Var != null) {
                kVar = a0Var.f5405h;
            }
        }
        if ((a0Var == null || a0Var.f5409m) && !this.l0) {
            x xVar = this.G;
            Window.Callback callback = this.F.getCallback();
            xVar.getClass();
            try {
                xVar.f5566y = true;
                callback.onPanelClosed(i, kVar);
            } finally {
                xVar.f5566y = false;
            }
        }
    }

    public final void r(m.k kVar) {
        n.k kVar2;
        if (this.f5420f0) {
            return;
        }
        this.f5420f0 = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.L;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((m3) actionBarOverlayLayout.f884y).f8443a.f942u;
        if (actionMenuView != null && (kVar2 = actionMenuView.N) != null) {
            kVar2.d();
            n.f fVar = kVar2.O;
            if (fVar != null && fVar.b()) {
                fVar.i.dismiss();
            }
        }
        Window.Callback callback = this.F.getCallback();
        if (callback != null && !this.l0) {
            callback.onPanelClosed(108, kVar);
        }
        this.f5420f0 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.e() != false) goto L20;
     */
    @Override // m.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(m.k r6) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b0.s(m.k):void");
    }

    public final void t(a0 a0Var, boolean z2) {
        z zVar;
        l1 l1Var;
        if (z2 && a0Var.f5399a == 0 && (l1Var = this.L) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) l1Var;
            actionBarOverlayLayout.k();
            if (((m3) actionBarOverlayLayout.f884y).f8443a.p()) {
                r(a0Var.f5405h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.E.getSystemService("window");
        if (windowManager != null && a0Var.f5409m && (zVar = a0Var.f5403e) != null) {
            windowManager.removeView(zVar);
            if (z2) {
                q(a0Var.f5399a, a0Var, null);
            }
        }
        a0Var.f5407k = false;
        a0Var.f5408l = false;
        a0Var.f5409m = false;
        a0Var.f = null;
        a0Var.f5410n = true;
        if (this.f5422h0 == a0Var) {
            this.f5422h0 = null;
        }
        if (a0Var.f5399a == 0) {
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
    public final boolean v(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b0.v(android.view.KeyEvent):boolean");
    }

    public final void w(int i) {
        a0 a0VarC = C(i);
        if (a0VarC.f5405h != null) {
            Bundle bundle = new Bundle();
            a0VarC.f5405h.u(bundle);
            if (bundle.size() > 0) {
                a0VarC.f5412p = bundle;
            }
            a0VarC.f5405h.y();
            a0VarC.f5405h.clear();
        }
        a0VarC.f5411o = true;
        a0VarC.f5410n = true;
        if ((i == 108 || i == 0) && this.L != null) {
            a0 a0VarC2 = C(0);
            a0VarC2.f5407k = false;
            J(a0VarC2, null);
        }
    }

    public final void x() {
        ViewGroup viewGroup;
        if (this.U) {
            return;
        }
        int[] iArr = g.j.AppCompatTheme;
        Context context = this.E;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowNoTitle, false)) {
            h(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowActionBar, false)) {
            h(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowActionBarOverlay, false)) {
            h(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_windowActionModeOverlay, false)) {
            h(10);
        }
        this.f5418d0 = typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        y();
        this.F.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f5419e0) {
            viewGroup = this.f5417c0 ? (ViewGroup) layoutInflaterFrom.inflate(g.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(g.g.abc_screen_simple, (ViewGroup) null);
        } else if (this.f5418d0) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(g.g.abc_dialog_title_material, (ViewGroup) null);
            this.f5416b0 = false;
            this.f5415a0 = false;
        } else if (this.f5415a0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(g.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new l.c(context, typedValue.resourceId) : context).inflate(g.g.abc_screen_toolbar, (ViewGroup) null);
            l1 l1Var = (l1) viewGroup.findViewById(g.f.decor_content_parent);
            this.L = l1Var;
            l1Var.setWindowCallback(this.F.getCallback());
            if (this.f5416b0) {
                ((ActionBarOverlayLayout) this.L).j(109);
            }
            if (this.Y) {
                ((ActionBarOverlayLayout) this.L).j(2);
            }
            if (this.Z) {
                ((ActionBarOverlayLayout) this.L).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f5415a0 + ", windowActionBarOverlay: " + this.f5416b0 + ", android:windowIsFloating: " + this.f5418d0 + ", windowActionModeOverlay: " + this.f5417c0 + ", windowNoTitle: " + this.f5419e0 + " }");
        }
        u5.c cVar = new u5.c(16, this);
        WeakHashMap weakHashMap = o0.f10475a;
        q0.f0.l(viewGroup, cVar);
        if (this.L == null) {
            this.W = (TextView) viewGroup.findViewById(g.f.title);
        }
        boolean z2 = u3.f8547a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e11) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(g.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.F.findViewById(R.id.content);
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
        this.F.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new u5.d(13, this));
        this.V = viewGroup;
        Object obj = this.D;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.K;
        if (!TextUtils.isEmpty(title)) {
            l1 l1Var2 = this.L;
            if (l1Var2 != null) {
                l1Var2.setWindowTitle(title);
            } else {
                com.bumptech.glide.d dVar = this.I;
                if (dVar != null) {
                    dVar.Q(title);
                } else {
                    TextView textView = this.W;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.V.findViewById(R.id.content);
        View decorView = this.F.getDecorView();
        contentFrameLayout2.A.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
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
        a0 a0VarC = C(0);
        if (this.l0 || a0VarC.f5405h != null) {
            return;
        }
        E(108);
    }

    public final void y() {
        if (this.F == null) {
            Object obj = this.D;
            if (obj instanceof Activity) {
                o(((Activity) obj).getWindow());
            }
        }
        if (this.F == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final Context z() {
        D();
        com.bumptech.glide.d dVar = this.I;
        Context contextU = dVar != null ? dVar.u() : null;
        return contextU == null ? this.E : contextU;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}

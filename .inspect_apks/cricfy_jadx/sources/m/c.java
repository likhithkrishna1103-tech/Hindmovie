package m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends ContextWrapper {
    public static Configuration f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f7969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f7970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f7971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f7972e;

    public c(Context context, int i) {
        super(context);
        this.f7968a = i;
    }

    public final void a(Configuration configuration) {
        if (this.f7972e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f7971d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f7971d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f7969b == null) {
            this.f7969b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f7969b.setTo(theme);
            }
        }
        this.f7969b.applyStyle(this.f7968a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f7972e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f7971d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = m.c.f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            m.c.f = r1
        L1c:
            android.content.res.Configuration r1 = m.c.f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f7971d
            android.content.Context r0 = r3.createConfigurationContext(r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f7972e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f7972e = r0
        L38:
            android.content.res.Resources r0 = r3.f7972e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.c.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f7970c == null) {
            this.f7970c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f7970c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f7969b;
        if (theme != null) {
            return theme;
        }
        if (this.f7968a == 0) {
            this.f7968a = g.i.Theme_AppCompat_Light;
        }
        b();
        return this.f7969b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.f7968a != i) {
            this.f7968a = i;
            b();
        }
    }
}

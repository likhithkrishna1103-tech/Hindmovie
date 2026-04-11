package l;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends ContextWrapper {
    public static Configuration f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f7754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f7755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f7756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f7757e;

    public c(Context context, int i) {
        super(context);
        this.f7753a = i;
    }

    public final void a(Configuration configuration) {
        if (this.f7757e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f7756d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f7756d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f7754b == null) {
            this.f7754b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f7754b.setTo(theme);
            }
        }
        this.f7754b.applyStyle(this.f7753a, true);
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
            android.content.res.Resources r0 = r3.f7757e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f7756d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = l.c.f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            l.c.f = r1
        L1c:
            android.content.res.Configuration r1 = l.c.f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f7756d
            android.content.Context r0 = r3.createConfigurationContext(r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f7757e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f7757e = r0
        L38:
            android.content.res.Resources r0 = r3.f7757e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.c.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f7755c == null) {
            this.f7755c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f7755c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f7754b;
        if (theme != null) {
            return theme;
        }
        if (this.f7753a == 0) {
            this.f7753a = g.i.Theme_AppCompat_Light;
        }
        b();
        return this.f7754b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.f7753a != i) {
            this.f7753a = i;
            b();
        }
    }
}

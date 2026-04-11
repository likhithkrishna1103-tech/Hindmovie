package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f1180j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile m f1181k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f1182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s.f f1183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f1184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f1185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f1186e;
    public final l f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t7.j f1187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1188h;
    public final e i;

    public m(u uVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1182a = reentrantReadWriteLock;
        this.f1184c = 3;
        l lVar = (l) uVar.f1175b;
        this.f = lVar;
        int i = uVar.f1174a;
        this.f1188h = i;
        this.i = (e) uVar.f1176c;
        this.f1185d = new Handler(Looper.getMainLooper());
        this.f1183b = new s.f(0);
        this.f1187g = new t7.j(2);
        g gVar = new g(this);
        this.f1186e = gVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.f1184c = 0;
            } catch (Throwable th) {
                this.f1182a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                lVar.a(new f(gVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static m a() {
        m mVar;
        synchronized (f1180j) {
            try {
                mVar = f1181k;
                if (!(mVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return mVar;
    }

    public final int b() {
        this.f1182a.readLock().lock();
        try {
            return this.f1184c;
        } finally {
            this.f1182a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f1188h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f1182a.writeLock().lock();
        try {
            if (this.f1184c == 0) {
                return;
            }
            this.f1184c = 0;
            this.f1182a.writeLock().unlock();
            g gVar = this.f1186e;
            m mVar = (m) gVar.f1173c;
            try {
                mVar.f.a(new f(gVar));
            } catch (Throwable th) {
                mVar.d(th);
            }
        } finally {
            this.f1182a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1182a.writeLock().lock();
        try {
            this.f1184c = 2;
            arrayList.addAll(this.f1183b);
            this.f1183b.clear();
            this.f1182a.writeLock().unlock();
            this.f1185d.post(new k(arrayList, this.f1184c, th));
        } catch (Throwable th2) {
            this.f1182a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092 A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #0 {all -> 0x0085, blocks: (B:32:0x005d, B:35:0x0062, B:37:0x0066, B:39:0x0073, B:46:0x0092, B:48:0x009c, B:50:0x009f, B:52:0x00a2, B:54:0x00b2, B:55:0x00b5), top: B:93:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:32:0x005d, B:35:0x0062, B:37:0x0066, B:39:0x0073, B:46:0x0092, B:48:0x009c, B:50:0x009f, B:52:0x00a2, B:54:0x00b2, B:55:0x00b5), top: B:93:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c4 A[Catch: all -> 0x00f9, TRY_ENTER, TryCatch #1 {all -> 0x00f9, blocks: (B:59:0x00c4, B:62:0x00cc, B:64:0x00d2, B:44:0x0088), top: B:95:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r11, int r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.m.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(j jVar) {
        cf.l.j(jVar, "initCallback cannot be null");
        this.f1182a.writeLock().lock();
        try {
            if (this.f1184c == 1 || this.f1184c == 2) {
                this.f1185d.post(new k(Arrays.asList(jVar), this.f1184c, (Throwable) null));
            } else {
                this.f1183b.add(jVar);
            }
            this.f1182a.writeLock().unlock();
        } catch (Throwable th) {
            this.f1182a.writeLock().unlock();
            throw th;
        }
    }
}

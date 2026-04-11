package va;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Charset f13458w = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final File f13459u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l f13460v;

    public m(File file) {
        this.f13459u = file;
    }

    @Override // va.c
    public final void a() {
        ta.f.b(this.f13460v, "There was a problem closing the Crashlytics log file.");
        this.f13460v = null;
    }

    public final void b() {
        File file = this.f13459u;
        if (this.f13460v == null) {
            try {
                this.f13460v = new l(file);
            } catch (IOException e10) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file, e10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // va.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c() {
        /*
            r7 = this;
            java.io.File r0 = r7.f13459u
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r4 = r2
            goto L38
        Lc:
            r7.b()
            va.l r0 = r7.f13460v
            if (r0 != 0) goto L14
            goto La
        L14:
            int[] r3 = new int[]{r1}
            int r0 = r0.g0()
            byte[] r0 = new byte[r0]
            va.l r4 = r7.f13460v     // Catch: java.io.IOException -> L29
            va.f r5 = new va.f     // Catch: java.io.IOException -> L29
            r5.<init>(r0, r3)     // Catch: java.io.IOException -> L29
            r4.x(r5)     // Catch: java.io.IOException -> L29
            goto L31
        L29:
            r4 = move-exception
            java.lang.String r5 = "A problem occurred while reading the Crashlytics log file."
            java.lang.String r6 = "FirebaseCrashlytics"
            android.util.Log.e(r6, r5, r4)
        L31:
            e6.i r4 = new e6.i
            r3 = r3[r1]
            r4.<init>(r3, r0)
        L38:
            if (r4 != 0) goto L3c
            r3 = r2
            goto L47
        L3c:
            int r0 = r4.f4522u
            byte[] r3 = new byte[r0]
            java.lang.Object r4 = r4.f4523v
            byte[] r4 = (byte[]) r4
            java.lang.System.arraycopy(r4, r1, r3, r1, r0)
        L47:
            if (r3 == 0) goto L51
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = va.m.f13458w
            r0.<init>(r3, r1)
            return r0
        L51:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: va.m.c():java.lang.String");
    }

    @Override // va.c
    public final void d(String str, long j5) {
        b();
        if (this.f13460v == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > 16384) {
                str = "..." + str.substring(str.length() - 16384);
            }
            this.f13460v.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j5), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f13458w));
            while (!this.f13460v.F() && this.f13460v.g0() > 65536) {
                this.f13460v.J();
            }
        } catch (IOException e10) {
            Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e10);
        }
    }
}

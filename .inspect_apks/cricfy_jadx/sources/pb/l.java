package pb;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Charset f10171x = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final File f10172v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public k f10173w;

    public l(File file) {
        this.f10172v = file;
    }

    public final void a() {
        File file = this.f10172v;
        if (this.f10173w == null) {
            try {
                this.f10173w = new k(file);
            } catch (IOException e9) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file, e9);
            }
        }
    }

    @Override // pb.c
    public final void b() {
        nb.f.b(this.f10173w, "There was a problem closing the Crashlytics log file.");
        this.f10173w = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // pb.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h() {
        /*
            r7 = this;
            java.io.File r0 = r7.f10172v
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r4 = r2
            goto L39
        Lc:
            r7.a()
            pb.k r0 = r7.f10173w
            if (r0 != 0) goto L14
            goto La
        L14:
            int[] r3 = new int[]{r1}
            int r0 = r0.R()
            byte[] r0 = new byte[r0]
            pb.k r4 = r7.f10173w     // Catch: java.io.IOException -> L29
            pb.e r5 = new pb.e     // Catch: java.io.IOException -> L29
            r5.<init>(r0, r3)     // Catch: java.io.IOException -> L29
            r4.s(r5)     // Catch: java.io.IOException -> L29
            goto L31
        L29:
            r4 = move-exception
            java.lang.String r5 = "A problem occurred while reading the Crashlytics log file."
            java.lang.String r6 = "FirebaseCrashlytics"
            android.util.Log.e(r6, r5, r4)
        L31:
            ag.o r4 = new ag.o
            r3 = r3[r1]
            r5 = 5
            r4.<init>(r3, r5, r0)
        L39:
            if (r4 != 0) goto L3d
            r3 = r2
            goto L48
        L3d:
            int r0 = r4.f454w
            byte[] r3 = new byte[r0]
            java.lang.Object r4 = r4.f455x
            byte[] r4 = (byte[]) r4
            java.lang.System.arraycopy(r4, r1, r3, r1, r0)
        L48:
            if (r3 == 0) goto L52
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = pb.l.f10171x
            r0.<init>(r3, r1)
            return r0
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.l.h():java.lang.String");
    }

    @Override // pb.c
    public final void s(String str, long j4) {
        a();
        if (this.f10173w == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > 16384) {
                str = "..." + str.substring(str.length() - 16384);
            }
            this.f10173w.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j4), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f10171x));
            while (!this.f10173w.z() && this.f10173w.R() > 65536) {
                this.f10173w.J();
            }
        } catch (IOException e9) {
            Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e9);
        }
    }
}

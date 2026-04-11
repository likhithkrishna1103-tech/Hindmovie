package e7;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import d7.s;
import d7.t;
import java.io.File;
import java.io.FileNotFoundException;
import qb.t1;
import x6.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.data.d {
    public static final String[] F = {"_data"};
    public final int A;
    public final h B;
    public final Class C;
    public volatile boolean D;
    public volatile com.bumptech.glide.load.data.d E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f3818v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t f3819w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t f3820x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Uri f3821y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3822z;

    public c(Context context, t tVar, t tVar2, Uri uri, int i, int i10, h hVar, Class cls) {
        this.f3818v = context.getApplicationContext();
        this.f3819w = tVar;
        this.f3820x = tVar2;
        this.f3821y = uri;
        this.f3822z = i;
        this.A = i10;
        this.B = hVar;
        this.C = cls;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return this.C;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        com.bumptech.glide.load.data.d dVar = this.E;
        if (dVar != null) {
            dVar.b();
        }
    }

    public final com.bumptech.glide.load.data.d c() throws Throwable {
        s sVarA;
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.f3818v;
        h hVar = this.B;
        int i = this.A;
        int i10 = this.f3822z;
        if (zIsExternalStorageLegacy) {
            Uri uri = this.f3821y;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, F, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            cursorQuery.close();
                            sVarA = this.f3819w.a(file, i10, i, hVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri requireOriginal = this.f3821y;
            boolean zJ = t1.j(requireOriginal);
            t tVar = this.f3820x;
            if (zJ && requireOriginal.getPathSegments().contains("picker")) {
                sVarA = tVar.a(requireOriginal, i10, i, hVar);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                sVarA = tVar.a(requireOriginal, i10, i, hVar);
            }
        }
        if (sVarA != null) {
            return sVarA.f3509c;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.D = true;
        com.bumptech.glide.load.data.d dVar = this.E;
        if (dVar != null) {
            dVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, com.bumptech.glide.load.data.c cVar) throws Throwable {
        try {
            com.bumptech.glide.load.data.d dVarC = c();
            if (dVarC == null) {
                cVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f3821y));
            } else {
                this.E = dVarC;
                if (this.D) {
                    cancel();
                } else {
                    dVarC.f(hVar, cVar);
                }
            }
        } catch (FileNotFoundException e9) {
            cVar.c(e9);
        }
    }
}

package j6;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import c6.i;
import com.bumptech.glide.f;
import i6.q;
import i6.r;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.data.e {
    public static final String[] E = {"_data"};
    public final i A;
    public final Class B;
    public volatile boolean C;
    public volatile com.bumptech.glide.load.data.e D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f6799u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r f6800v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r f6801w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Uri f6802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f6803y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f6804z;

    public c(Context context, r rVar, r rVar2, Uri uri, int i, int i10, i iVar, Class cls) {
        this.f6799u = context.getApplicationContext();
        this.f6800v = rVar;
        this.f6801w = rVar2;
        this.f6802x = uri;
        this.f6803y = i;
        this.f6804z = i10;
        this.A = iVar;
        this.B = cls;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return this.B;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        com.bumptech.glide.load.data.e eVar = this.D;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.C = true;
        com.bumptech.glide.load.data.e eVar = this.D;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public final com.bumptech.glide.load.data.e d() throws Throwable {
        q qVarA;
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.f6799u;
        i iVar = this.A;
        int i = this.f6804z;
        int i10 = this.f6803y;
        if (zIsExternalStorageLegacy) {
            Uri uri = this.f6802x;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, E, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            cursorQuery.close();
                            qVarA = this.f6800v.a(file, i10, i, iVar);
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
            Uri requireOriginal = this.f6802x;
            boolean zC = i5.a.C(requireOriginal);
            r rVar = this.f6801w;
            if (zC && requireOriginal.getPathSegments().contains("picker")) {
                qVarA = rVar.a(requireOriginal, i10, i, iVar);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                qVarA = rVar.a(requireOriginal, i10, i, iVar);
            }
        }
        if (qVarA != null) {
            return qVarA.f6422c;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(f fVar, com.bumptech.glide.load.data.d dVar) throws Throwable {
        try {
            com.bumptech.glide.load.data.e eVarD = d();
            if (eVarD == null) {
                dVar.l(new IllegalArgumentException("Failed to build fetcher for: " + this.f6802x));
            } else {
                this.D = eVarD;
                if (this.C) {
                    cancel();
                } else {
                    eVarD.e(fVar, dVar);
                }
            }
        } catch (FileNotFoundException e10) {
            dVar.l(e10);
        }
    }
}

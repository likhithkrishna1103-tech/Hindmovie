package q0;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v.j f10324a = new v.j(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g4.d f10325b = new g4.d(8);

    public static h4.f a(Context context, List list) {
        com.bumptech.glide.c.b("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                ProviderInfo providerInfoB = b(context.getPackageManager(), dVar, context.getResources());
                if (providerInfoB == null) {
                    return new h4.f();
                }
                arrayList.add(c(context, dVar, providerInfoB.authority));
            }
            return new h4.f(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, d dVar, Resources resources) {
        g4.d dVar2 = f10325b;
        v.j jVar = f10324a;
        com.bumptech.glide.c.b("FontProvider.getProvider");
        try {
            List listK = dVar.f10329d;
            String str = dVar.f10326a;
            String str2 = dVar.f10327b;
            if (listK == null) {
                listK = k0.b.k(resources, 0);
            }
            b bVar = new b();
            bVar.f10321a = str;
            bVar.f10322b = str2;
            bVar.f10323c = listK;
            ProviderInfo providerInfo = (ProviderInfo) jVar.h(bVar);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, dVar2);
            for (int i = 0; i < listK.size(); i++) {
                ArrayList arrayList2 = new ArrayList((Collection) listK.get(i));
                Collections.sort(arrayList2, dVar2);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i10), (byte[]) arrayList2.get(i10))) {
                            break;
                        }
                    }
                    jVar.l(bVar, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static i[] c(Context context, d dVar, String str) {
        a aVar;
        ArrayList arrayList;
        Uri uriWithAppendedId;
        com.bumptech.glide.c.b("FontProvider.query");
        try {
            ArrayList arrayList2 = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            if (Build.VERSION.SDK_INT < 24) {
                l4.a aVar2 = new l4.a();
                aVar2.f7697v = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                aVar = aVar2;
            } else {
                m2.e eVar = new m2.e();
                eVar.f8050v = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                aVar = eVar;
            }
            Cursor cursorB = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                com.bumptech.glide.c.b("ContentQueryWrapper.query");
                try {
                    cursorB = aVar.b(uriBuild, strArr, new String[]{dVar.f10328c});
                    Trace.endSection();
                    if (cursorB != null && cursorB.getCount() > 0) {
                        int columnIndex = cursorB.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursorB.getColumnIndex("_id");
                        int columnIndex3 = cursorB.getColumnIndex("file_id");
                        int columnIndex4 = cursorB.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorB.getColumnIndex("font_weight");
                        int columnIndex6 = cursorB.getColumnIndex("font_italic");
                        while (cursorB.moveToNext()) {
                            int i = columnIndex != -1 ? cursorB.getInt(columnIndex) : 0;
                            int i10 = columnIndex4 != -1 ? cursorB.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                arrayList = arrayList3;
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursorB.getLong(columnIndex2));
                            } else {
                                arrayList = arrayList3;
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursorB.getLong(columnIndex3));
                            }
                            Uri uri = uriWithAppendedId;
                            ArrayList arrayList4 = arrayList;
                            arrayList4.add(new i(uri, i10, columnIndex5 != -1 ? cursorB.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorB.getInt(columnIndex6) == 1, i));
                            arrayList3 = arrayList4;
                        }
                        arrayList2 = arrayList3;
                    }
                    if (cursorB != null) {
                        cursorB.close();
                    }
                    aVar.close();
                    return (i[]) arrayList2.toArray(new i[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorB != null) {
                    cursorB.close();
                }
                aVar.close();
                throw th;
            }
        } finally {
        }
    }
}

package n0;

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
import n.a1;
import q4.e1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f8609a = new e1(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c4.d f8610b = new c4.d(6);

    public static d4.f a(Context context, List list) {
        com.bumptech.glide.d.e("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                ProviderInfo providerInfoB = b(context.getPackageManager(), dVar, context.getResources());
                if (providerInfoB == null) {
                    return new d4.f();
                }
                arrayList.add(c(context, dVar, providerInfoB.authority));
            }
            return new d4.f(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, d dVar, Resources resources) {
        c4.d dVar2 = f8610b;
        e1 e1Var = f8609a;
        com.bumptech.glide.d.e("FontProvider.getProvider");
        try {
            List listK = dVar.f8614d;
            String str = dVar.f8611a;
            String str2 = dVar.f8612b;
            if (listK == null) {
                listK = h0.b.k(resources, 0);
            }
            b bVar = new b();
            bVar.f8606a = str;
            bVar.f8607b = str2;
            bVar.f8608c = listK;
            ProviderInfo providerInfo = (ProviderInfo) e1Var.g(bVar);
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
                    e1Var.k(bVar, providerInfoResolveContentProvider);
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
        a dVar2;
        ArrayList arrayList;
        Uri uriWithAppendedId;
        com.bumptech.glide.d.e("FontProvider.query");
        try {
            ArrayList arrayList2 = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            if (Build.VERSION.SDK_INT < 24) {
                a1 a1Var = new a1();
                a1Var.f8343u = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                dVar2 = a1Var;
            } else {
                dVar2 = new u5.d(context, uriBuild);
            }
            Cursor cursorH = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                com.bumptech.glide.d.e("ContentQueryWrapper.query");
                try {
                    cursorH = dVar2.h(uriBuild, strArr, new String[]{dVar.f8613c});
                    Trace.endSection();
                    if (cursorH != null && cursorH.getCount() > 0) {
                        int columnIndex = cursorH.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursorH.getColumnIndex("_id");
                        int columnIndex3 = cursorH.getColumnIndex("file_id");
                        int columnIndex4 = cursorH.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorH.getColumnIndex("font_weight");
                        int columnIndex6 = cursorH.getColumnIndex("font_italic");
                        while (cursorH.moveToNext()) {
                            int i = columnIndex != -1 ? cursorH.getInt(columnIndex) : 0;
                            int i10 = columnIndex4 != -1 ? cursorH.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                arrayList = arrayList3;
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursorH.getLong(columnIndex2));
                            } else {
                                arrayList = arrayList3;
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursorH.getLong(columnIndex3));
                            }
                            Uri uri = uriWithAppendedId;
                            ArrayList arrayList4 = arrayList;
                            arrayList4.add(new i(uri, i10, columnIndex5 != -1 ? cursorH.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorH.getInt(columnIndex6) == 1, i));
                            arrayList3 = arrayList4;
                        }
                        arrayList2 = arrayList3;
                    }
                    if (cursorH != null) {
                        cursorH.close();
                    }
                    dVar2.close();
                    return (i[]) arrayList2.toArray(new i[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorH != null) {
                    cursorH.close();
                }
                dVar2.close();
                throw th;
            }
        } finally {
        }
    }
}

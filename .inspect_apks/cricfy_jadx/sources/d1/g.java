package d1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends xd.h implements fe.l {
    public int A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3230z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, vd.c cVar, int i) {
        super(1, cVar);
        this.f3230z = i;
        this.B = obj;
    }

    @Override // fe.l
    public final Object a(Object obj) {
        vd.c cVar = (vd.c) obj;
        switch (this.f3230z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new g((f1.d) this.B, cVar, 0).o(rd.l.f11003a);
            default:
                return new g((d0) this.B, cVar, 1).o(rd.l.f11003a);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        Context context;
        String str;
        switch (this.f3230z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                rd.l lVar = rd.l.f11003a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return lVar;
                }
                com.bumptech.glide.c.C(obj);
                f1.d dVar = (f1.d) this.B;
                this.A = 1;
                SharedPreferences.Editor editorEdit = ((SharedPreferences) dVar.f3925e.getValue()).edit();
                Set set = dVar.f;
                if (set == null) {
                    editorEdit.clear();
                } else {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        editorEdit.remove((String) it.next());
                    }
                }
                if (!editorEdit.commit()) {
                    throw new IOException("Unable to delete migrated keys from SharedPreferences.");
                }
                if (((SharedPreferences) dVar.f3925e.getValue()).getAll().isEmpty() && (context = dVar.f3923c) != null && (str = dVar.f3924d) != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        f1.b.a(context, str);
                    } else {
                        File file = new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), str.concat(".xml"));
                        File file2 = new File(file.getPath() + ".bak");
                        file.delete();
                        file2.delete();
                    }
                }
                if (set != null) {
                    set.clear();
                }
                wd.a aVar = wd.a.f14143v;
                return lVar == aVar ? aVar : lVar;
            default:
                int i10 = this.A;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return obj;
                }
                com.bumptech.glide.c.C(obj);
                d0 d0Var = (d0) this.B;
                this.A = 1;
                Object objA = d0Var.a(this);
                wd.a aVar2 = wd.a.f14143v;
                return objA == aVar2 ? aVar2 : objA;
        }
    }
}

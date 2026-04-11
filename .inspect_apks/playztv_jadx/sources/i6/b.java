package i6;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6381c;

    public /* synthetic */ b(Object obj, int i, Object obj2) {
        this.f6379a = i;
        this.f6381c = obj;
        this.f6380b = obj2;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, c6.i iVar) {
        com.bumptech.glide.load.data.k kVar;
        q qVarA;
        Uri uri;
        switch (this.f6379a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri uri2 = (Uri) obj;
                String strSubstring = uri2.toString().substring(22);
                w6.d dVar = new w6.d(uri2);
                AssetManager assetManager = (AssetManager) this.f6381c;
                switch (((a) this.f6380b).f6375a) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        kVar = new com.bumptech.glide.load.data.k(assetManager, strSubstring, 0);
                        break;
                    default:
                        kVar = new com.bumptech.glide.load.data.k(assetManager, strSubstring, 1);
                        break;
                }
                return new q(dVar, kVar);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) iVar.c(n6.c.f8821b);
                return new q(new w6.d(num), new f(theme, theme != null ? theme.getResources() : ((Context) this.f6381c).getResources(), (e) this.f6380b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.f6381c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                c6.f fVar = null;
                for (int i11 = 0; i11 < size; i11++) {
                    r rVar = (r) arrayList.get(i11);
                    if (rVar.b(obj) && (qVarA = rVar.a(obj, i, i10, iVar)) != null) {
                        fVar = qVarA.f6420a;
                        arrayList2.add(qVarA.f6422c);
                    }
                }
                if (arrayList2.isEmpty() || fVar == null) {
                    return null;
                }
                return new q(fVar, new v(arrayList2, (p0.c) this.f6380b));
            case 3:
                Integer num2 = (Integer) obj;
                Resources resources = (Resources) this.f6380b;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num2.intValue()) + '/' + resources.getResourceTypeName(num2.intValue()) + '/' + resources.getResourceEntryName(num2.intValue()));
                    break;
                } catch (Resources.NotFoundException e10) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num2, e10);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((r) this.f6381c).a(uri, i, i10, iVar);
            default:
                Uri uri3 = (Uri) obj;
                r rVar2 = (r) this.f6380b;
                List<String> pathSegments = uri3.getPathSegments();
                q qVarA2 = null;
                if (pathSegments.size() == 1) {
                    try {
                        int i12 = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (i12 != 0) {
                            qVarA2 = rVar2.a(Integer.valueOf(i12), i, i10, iVar);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri3);
                        }
                        return qVarA2;
                    } catch (NumberFormatException e11) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return qVarA2;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri3, e11);
                        return qVarA2;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri3);
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.f6381c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return rVar2.a(Integer.valueOf(identifier), i, i10, iVar);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri3);
                return null;
        }
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        switch (this.f6379a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                ArrayList arrayList = (ArrayList) this.f6381c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    if (((r) obj2).b(obj)) {
                        return true;
                    }
                }
                return false;
            case 3:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.f6381c).getPackageName().equals(uri2.getAuthority());
        }
    }

    public String toString() {
        switch (this.f6379a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f6381c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public b(Resources resources, r rVar) {
        this.f6379a = 3;
        this.f6380b = resources;
        this.f6381c = rVar;
    }

    public b(Context context, e eVar) {
        this.f6379a = 1;
        this.f6381c = context.getApplicationContext();
        this.f6380b = eVar;
    }

    public b(Context context, r rVar) {
        this.f6379a = 4;
        this.f6381c = context.getApplicationContext();
        this.f6380b = rVar;
    }
}

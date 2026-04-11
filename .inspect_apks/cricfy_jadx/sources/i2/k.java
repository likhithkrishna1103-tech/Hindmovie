package i2;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import com.google.android.gms.common.api.Status;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements j9.a, n2.s, j9.d, j9.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f6085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f6086w;

    public /* synthetic */ k(Object obj) {
        this.f6086w = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i2.k a(android.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L27 java.lang.Error -> L2a java.io.IOException -> L2c
            i2.k r2 = new i2.k     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            return r2
        L21:
            r2 = move-exception
            goto L36
        L23:
            r2 = move-exception
            goto L36
        L25:
            r2 = move-exception
            goto L36
        L27:
            r2 = move-exception
        L28:
            r0 = r1
            goto L36
        L2a:
            r2 = move-exception
            goto L28
        L2c:
            r2 = move-exception
            goto L28
        L2e:
            r2 = move-exception
        L2f:
            r5 = r1
            r0 = r5
            goto L36
        L32:
            r2 = move-exception
            goto L2f
        L34:
            r2 = move-exception
            goto L2f
        L36:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L42
            r0.release()     // Catch: java.io.IOException -> L42
        L42:
            if (r5 == 0) goto L47
            r5.close()     // Catch: java.io.IOException -> L47
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.k.a(android.content.Context):i2.k");
    }

    public static g7.a0 e(ImageDecoder.Source source, int i, int i10, x6.h hVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new f7.b(i, i10, hVar));
        if (androidx.emoji2.text.b.w(drawableDecodeDrawable)) {
            return new g7.a0(2, androidx.emoji2.text.b.j(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    @Override // j9.d
    public void A(j9.p pVar) {
        ((Map) ((k) this.f6086w).f6086w).remove((j9.i) this.f6085v);
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        Boolean bool = (Boolean) obj;
        nb.l lVar = (nb.l) this.f6086w;
        if (bool.booleanValue()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
            }
            boolean zBooleanValue = bool.booleanValue();
            n8.k kVar = lVar.f8956b;
            if (zBooleanValue) {
                ((j9.i) kVar.A).c(null);
                return ((j9.p) this.f6085v).k(lVar.f8959e.f9742a, new kf.i(8, this));
            }
            kVar.getClass();
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
        }
        tb.c cVar = lVar.f8960g;
        Iterator it = tb.c.e(((File) cVar.f11985x).listFiles(nb.l.f8953r)).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        tb.c cVar2 = ((tb.a) lVar.f8965m.f2036c).f11979b;
        tb.a.a(tb.c.e(((File) cVar2.f11987z).listFiles()));
        tb.a.a(tb.c.e(((File) cVar2.A).listFiles()));
        tb.a.a(tb.c.e(((File) cVar2.B).listFiles()));
        lVar.f8969q.c(null);
        return vf.g.A(null);
    }

    public void b() {
        String str = (String) this.f6085v;
        try {
            tb.c cVar = (tb.c) this.f6086w;
            cVar.getClass();
            new File((File) cVar.f11985x, str).createNewFile();
        } catch (IOException e9) {
            Log.e("FirebaseCrashlytics", "Error creating marker: ".concat(str), e9);
        }
    }

    @Override // j9.a
    public Object c(j9.p pVar) {
        Bundle bundle;
        k8.b bVar = (k8.b) this.f6085v;
        Bundle bundle2 = (Bundle) this.f6086w;
        bVar.getClass();
        return (pVar.j() && (bundle = (Bundle) pVar.h()) != null && bundle.containsKey("google.messenger")) ? bVar.a(bundle2).k(k8.h.f7261x, k8.d.f7256y) : pVar;
    }

    public String d(String str, boolean z10) throws IOException {
        ge.i.e(str, "file");
        Context context = (Context) this.f6085v;
        ge.i.e(context, "context");
        if (!android.support.v4.media.session.b.E(str)) {
            return com.bumptech.glide.c.f(str, z10);
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        throw new IOException("FNC");
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return str;
                }
            } else if (scheme.equals("file")) {
                String path = uri.getPath();
                if (path != null) {
                    str = path;
                }
                return com.bumptech.glide.c.f(str, z10);
            }
        }
        throw new IOException("FNC");
    }

    public ya.w f(byte[] bArr) {
        byte[] bArr2;
        androidx.emoji2.text.v vVar = (androidx.emoji2.text.v) this.f6086w;
        if (vVar != null && (bArr2 = (byte[]) vVar.f888w) != null && Arrays.equals(bArr2, bArr)) {
            ya.w wVar = (ya.w) ((androidx.emoji2.text.v) this.f6086w).f890y;
            y1.d.h(wVar);
            return wVar;
        }
        b2.k kVar = (b2.k) this.f6085v;
        ya.w wVarA = ((ya.y) kVar.f1697a).a(new b2.j(0, kVar, bArr));
        this.f6086w = new androidx.emoji2.text.v(bArr, wVarA);
        return wVarA;
    }

    public void g(g2.f fVar) {
        synchronized (fVar) {
        }
        Handler handler = (Handler) this.f6085v;
        if (handler != null) {
            handler.post(new androidx.fragment.app.d(15, this, fVar));
        }
    }

    public byte[] h(l3.a aVar) {
        DataOutputStream dataOutputStream = (DataOutputStream) this.f6086w;
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.f6085v;
        byteArrayOutputStream.reset();
        try {
            dataOutputStream.writeBytes(aVar.f7692a);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeBytes(aVar.f7693b);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeLong(aVar.f7694c);
            dataOutputStream.writeLong(aVar.f7695d);
            dataOutputStream.write(aVar.f7696e);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e9) {
            throw new RuntimeException(e9);
        }
    }

    public boolean i(String str) {
        ge.i.e(str, "file");
        if (str.length() == 0) {
            return false;
        }
        try {
            ContentResolver contentResolver = ((Context) this.f6085v).getContentResolver();
            ge.i.d(contentResolver, "getContentResolver(...)");
            com.bumptech.glide.c.q(str, contentResolver).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public File j() {
        if (((File) this.f6085v) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f6085v) == null) {
                        String str = "PersistedInstallation." + ((ab.g) this.f6086w).d() + ".json";
                        ab.g gVar = (ab.g) this.f6086w;
                        gVar.a();
                        File file = new File(gVar.f390a.getNoBackupFilesDir(), str);
                        this.f6085v = file;
                        if (file.exists()) {
                            return (File) this.f6085v;
                        }
                        ab.g gVar2 = (ab.g) this.f6086w;
                        gVar2.a();
                        File file2 = new File(gVar2.f390a.getFilesDir(), str);
                        if (file2.exists() && !file2.renameTo((File) this.f6085v)) {
                            Log.e("PersistedInstallation", "Unable to move the file from back up to non back up directory", new IOException("Unable to move the file from back up to non back up directory"));
                            return file2;
                        }
                    }
                } finally {
                }
            }
        }
        return (File) this.f6085v;
    }

    public synchronized List k(String str) {
        List arrayList;
        try {
            if (!((ArrayList) this.f6085v).contains(str)) {
                ((ArrayList) this.f6085v).add(str);
            }
            arrayList = (List) ((HashMap) this.f6086w).get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                ((HashMap) this.f6086w).put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized ArrayList l(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.f6085v;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            List<n7.c> list = (List) ((HashMap) this.f6086w).get((String) obj);
            if (list != null) {
                for (n7.c cVar : list) {
                    if ((cVar.f8853a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f8854b)) && !arrayList.contains(cVar.f8854b)) {
                        arrayList.add(cVar.f8854b);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // n2.s
    public w2.q m() {
        return new nb.w(9, ((n2.s) this.f6085v).m(), (List) this.f6086w);
    }

    public void n(jc.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.f6736a);
            jSONObject.put("Status", y.e.c(bVar.f6737b));
            jSONObject.put("AuthToken", bVar.f6738c);
            jSONObject.put("RefreshToken", bVar.f6739d);
            jSONObject.put("TokenCreationEpochInSecs", bVar.f);
            jSONObject.put("ExpiresInSecs", bVar.f6740e);
            jSONObject.put("FisError", bVar.f6741g);
            ab.g gVar = (ab.g) this.f6086w;
            gVar.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", gVar.f390a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(j())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public void o(int i, Bundle bundle) {
        Locale locale = Locale.US;
        String str = "Analytics listener received message. ID: " + i + ", Extras: " + bundle;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
        String string = bundle.getString("name");
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            lb.b bVar = "clx".equals(bundle2.getString("_o")) ? (l7.a) this.f6085v : (kf.i) this.f6086w;
            if (bVar == null) {
                return;
            }
            bVar.A(string, bundle2);
        }
    }

    public void p(Exception exc, boolean z10) {
        this.f6086w = null;
        HashSet hashSet = (HashSet) this.f6085v;
        ua.i0 i0VarK = ua.i0.k(hashSet);
        hashSet.clear();
        ua.g0 g0VarM = i0VarK.listIterator(0);
        while (g0VarM.hasNext()) {
            l2.c cVar = (l2.c) g0VarM.next();
            cVar.getClass();
            cVar.k(exc, z10 ? 1 : 3);
        }
    }

    public void q(String str, long j4) throws IOException {
        ge.i.e(str, "file");
        if (str.length() == 0) {
            throw new FileNotFoundException(str.concat(" file_not_found"));
        }
        if (j4 < 1) {
            return;
        }
        Context context = (Context) this.f6085v;
        ge.i.e(context, "context");
        if (!android.support.v4.media.session.b.E(str)) {
            com.bumptech.glide.c.a(new File(str), j4);
            return;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        throw new IOException("file_allocation_error");
                    }
                    if (j4 > 0) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            if (fileOutputStream.getChannel().size() == j4) {
                                return;
                            }
                            fileOutputStream.getChannel().position(j4 - 1);
                            fileOutputStream.write(1);
                            return;
                        } catch (Exception unused) {
                            throw new IOException("file_allocation_error");
                        }
                    }
                    return;
                }
            } else if (scheme.equals("file")) {
                String path = uri.getPath();
                if (path != null) {
                    str = path;
                }
                com.bumptech.glide.c.a(new File(str), j4);
                return;
            }
        }
        throw new IOException("file_allocation_error");
    }

    public void r(l2.c cVar) {
        ((HashSet) this.f6085v).add(cVar);
        if (((l2.c) this.f6086w) != null) {
            return;
        }
        this.f6086w = cVar;
        l2.t tVarG = cVar.f7635b.g();
        cVar.f7655x = tVarG;
        l2.a aVar = cVar.f7649r;
        int i = y1.a0.f14551a;
        tVarG.getClass();
        aVar.getClass();
        aVar.obtainMessage(1, new l2.b(s2.t.f11325b.getAndIncrement(), true, SystemClock.elapsedRealtime(), tVarG)).sendToTarget();
    }

    public void s(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((v.e) this.f6086w)) {
            ((v.e) this.f6086w).put(new s7.k(cls, cls2, cls3), list);
        }
    }

    @Override // n2.s
    public w2.q t(n2.o oVar, n2.l lVar) {
        return new nb.w(9, ((n2.s) this.f6085v).t(oVar, lVar), (List) this.f6086w);
    }

    public jc.b u() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(j());
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } finally {
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i10 = jc.b.f6735h;
        byte b8 = (byte) (((byte) (0 | 2)) | 1);
        int i11 = y.e.d(5)[iOptInt];
        if (i11 == 0) {
            throw new NullPointerException("Null registrationStatus");
        }
        byte b10 = (byte) (((byte) (b8 | 2)) | 1);
        if (b10 == 3 && i11 != 0) {
            return new jc.b(strOptString, i11, strOptString2, strOptString3, jOptLong2, jOptLong, strOptString4);
        }
        StringBuilder sb = new StringBuilder();
        if (i11 == 0) {
            sb.append(" registrationStatus");
        }
        if ((b10 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b10 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }

    public void v() {
        try {
            ((FileLock) this.f6086w).release();
            ((FileChannel) this.f6085v).close();
        } catch (IOException e9) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e9);
        }
    }

    public void w(boolean z10, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f6085v)) {
            map = new HashMap((Map) this.f6085v);
        }
        synchronized (((Map) this.f6086w)) {
            map2 = new HashMap((Map) this.f6086w);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((j9.i) entry2.getKey()).b(new q(status));
            }
        }
    }

    public /* synthetic */ k(Object obj, Object obj2) {
        this.f6085v = obj;
        this.f6086w = obj2;
    }

    public /* synthetic */ k(Object obj, Object obj2, boolean z10) {
        this.f6086w = obj;
        this.f6085v = obj2;
    }

    public k(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f6085v = new Messenger(iBinder);
            this.f6086w = null;
        } else if (Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
            this.f6086w = new k8.g(iBinder);
            this.f6085v = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    public k(Context context, String str) {
        ge.i.e(context, "context");
        ge.i.e(str, "defaultTempDir");
        this.f6085v = context;
        this.f6086w = str;
    }

    public k(Context context, int i) {
        switch (i) {
            case 13:
                this.f6085v = context;
                this.f6086w = null;
                break;
            default:
                this.f6085v = context == null ? null : context.getApplicationContext();
                break;
        }
    }

    public k(Handler handler, l lVar) {
        if (lVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f6085v = handler;
        this.f6086w = lVar;
    }

    public k(int i) {
        switch (i) {
            case 14:
                this.f6085v = new HashSet();
                break;
            case 15:
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                this.f6085v = byteArrayOutputStream;
                this.f6086w = new DataOutputStream(byteArrayOutputStream);
                break;
            case 19:
                this.f6085v = new Rect();
                this.f6086w = new Rect();
                break;
            case 23:
                this.f6085v = new AtomicReference();
                this.f6086w = new v.e(0);
                break;
            case 24:
                this.f6085v = new ArrayList();
                this.f6086w = new HashMap();
                break;
            case 26:
                this.f6085v = Collections.synchronizedMap(new WeakHashMap());
                this.f6086w = Collections.synchronizedMap(new WeakHashMap());
                break;
            default:
                this.f6085v = Choreographer.getInstance();
                this.f6086w = Looper.myLooper();
                break;
        }
    }
}

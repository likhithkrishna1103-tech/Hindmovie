package nd;

import ge.i;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Socket f9111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataInputStream f9112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataOutputStream f9113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f9114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f9115e;

    public a() {
        Socket socket = new Socket();
        this.f9111a = socket;
        this.f9114d = new Object();
        if (socket.isConnected() && !socket.isClosed()) {
            this.f9112b = new DataInputStream(socket.getInputStream());
            this.f9113c = new DataOutputStream(socket.getOutputStream());
        }
        if (socket.isClosed()) {
            this.f9115e = true;
        }
    }

    public final void a() {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        synchronized (this.f9114d) {
            try {
                if (!this.f9115e) {
                    this.f9115e = true;
                    try {
                        dataInputStream = this.f9112b;
                    } catch (Exception unused) {
                    }
                    if (dataInputStream == null) {
                        i.i("dataInput");
                        throw null;
                    }
                    dataInputStream.close();
                    try {
                        dataOutputStream = this.f9113c;
                    } catch (Exception unused2) {
                    }
                    if (dataOutputStream == null) {
                        i.i("dataOutput");
                        throw null;
                    }
                    dataOutputStream.close();
                    try {
                        this.f9111a.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final DataInputStream b() {
        DataInputStream dataInputStream;
        synchronized (this.f9114d) {
            e();
            f();
            dataInputStream = this.f9112b;
            if (dataInputStream == null) {
                i.i("dataInput");
                throw null;
            }
        }
        return dataInputStream;
    }

    public final e c() {
        e eVar;
        synchronized (this.f9114d) {
            e();
            f();
            DataInputStream dataInputStream = this.f9112b;
            if (dataInputStream == null) {
                i.i("dataInput");
                throw null;
            }
            String utf = dataInputStream.readUTF();
            i.d(utf, "readUTF(...)");
            String lowerCase = utf.toLowerCase(Locale.ROOT);
            i.d(lowerCase, "toLowerCase(...)");
            JSONObject jSONObject = new JSONObject(lowerCase);
            int i = jSONObject.getInt("status");
            int i10 = jSONObject.getInt("type");
            int i11 = jSONObject.getInt("connection");
            long j4 = jSONObject.getLong("date");
            long j7 = jSONObject.getLong("content-length");
            String string = jSONObject.getString("md5");
            String string2 = jSONObject.getString("sessionid");
            i.b(string);
            i.b(string2);
            eVar = new e(i, i10, i11, j4, j7, string, string2);
        }
        return eVar;
    }

    public final void d(c cVar) {
        synchronized (this.f9114d) {
            e();
            f();
            DataOutputStream dataOutputStream = this.f9113c;
            if (dataOutputStream == null) {
                i.i("dataOutput");
                throw null;
            }
            dataOutputStream.writeUTF(cVar.a());
            DataOutputStream dataOutputStream2 = this.f9113c;
            if (dataOutputStream2 == null) {
                i.i("dataOutput");
                throw null;
            }
            dataOutputStream2.flush();
        }
    }

    public final void e() throws Exception {
        if (this.f9115e) {
            throw new Exception("FetchFileResourceTransporter is already closed.");
        }
    }

    public final void f() {
        if (this.f9112b == null) {
            i.i("dataInput");
            throw null;
        }
        if (this.f9113c != null) {
            return;
        }
        i.i("dataOutput");
        throw null;
    }
}

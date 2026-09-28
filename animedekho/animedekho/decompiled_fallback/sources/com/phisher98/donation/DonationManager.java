package com.phisher98.donation;

/* JADX INFO: compiled from: DonationManager.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010J\u001a\u00020\u0013H\u0002J\u0010\u0010K\u001a\u00020I2\b\b\u0002\u0010L\u001a\u00020\u0013J$\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000206\u0018\u00010N2\u0006\u0010O\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010PR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u00020\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/phisher98/donation/DonationManager;", "", "<init>", "()V", "testMode", "", "getTestMode", "()Z", "setTestMode", "(Z)V", "testProgressAmount", "", "getTestProgressAmount", "()D", "setTestProgressAmount", "(D)V", "isDialogShowing", "setDialogShowing", "OBFUSCATED_TOKEN", "", "getDecryptedBmcToken", "primaryDonateUrl", "getPrimaryDonateUrl", "()Ljava/lang/String;", "setPrimaryDonateUrl", "(Ljava/lang/String;)V", "primaryButtonText", "getPrimaryButtonText", "setPrimaryButtonText", "secondaryDonateUrl", "getSecondaryDonateUrl", "setSecondaryDonateUrl", "secondaryButtonText", "getSecondaryButtonText", "setSecondaryButtonText", "adSupportUrl", "getAdSupportUrl", "setAdSupportUrl", "adSupportButtonText", "getAdSupportButtonText", "setAdSupportButtonText", "targetAmount", "getTargetAmount", "setTargetAmount", "currency", "getCurrency", "setCurrency", "goalTitle", "getGoalTitle", "setGoalTitle", "goalDescription", "getGoalDescription", "setGoalDescription", "cooldownHours", "", "getCooldownHours", "()I", "setCooldownHours", "(I)V", "PREFS_NAME", "KEY_LAST_SHOWN", "KEY_CACHED_MONTH", "KEY_CACHED_AMOUNT", "KEY_CACHED_SUPPORTERS", "DIALOG_TAG", "gateLock", "isLaunching", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "isCooldownActive", "recordShown", "", "getCurrentMonthName", "checkAndShow", "providerName", "fetchBuyMeACoffeeMonthly", "Lkotlin/Pair;", "accessToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,457:1\n40#2,11:458\n1#3:469\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n*L\n126#1:458,11\n*E\n"})
public final class DonationManager {

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DIALOG_TAG = "phisher_donation_floating_dialog";

    @org.jetbrains.annotations.NotNull
    public static final com.phisher98.donation.DonationManager INSTANCE = null;

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CACHED_AMOUNT = "phisher_donation_cached_amount";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CACHED_MONTH = "phisher_donation_cached_month";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CACHED_SUPPORTERS = "phisher_donation_cached_supporters";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_LAST_SHOWN = "phisher_donation_last_shown_v2";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String OBFUSCATED_TOKEN = "FREjQw09MzYsBSU+MkIlGykiJzcAKgA2JAwzDGdKewc+ASNKRgALFQsIOCQNPB07UCw5Flc3JxYcKDpuWWlmUhskPSECPEASFyM4JB4pN0JULikeUiA3Cls/LThLfVhvGSQqORkBNTQKIwY/CD4eJ1E7BzMJIDQWHCgTN1p+AHgYJy02Eio2BQs1ODsOPUYgDS8pHhggDg4RKxMKSGpfcBklEzpdKzUJDiEFFh49GSNUOwcOUTckEhIqLRVefl9nCTEDKlwqJhpTNjgjDD4wGR84XwZRNzAWGCwUM1pUcX9GJT0QXCo2BlYhFTRXPh0FDAMAFQ8kCTATKwM4Bn5YXQolLRARKTEVDwknNA08HjdRLCkOGCAZGlsrAxpBeVx4QTEAOl4sGDQbISseUT4OPwwtLhUYNFFmHD8hElt/XkUZCwQlAD8xbhUOAg1ROhhDXE8qNwonFT0mJ0o2AAB4f10lXkIBAxoWEiMJFAIiPB4dOAptCxwMGzMIEiVCdV1sEh09MQ41PGo2A102XR8xJicUHgcpIiEQOAM3HlFvX1glARsrHQA7FigOMEAPKzA7MigrCltYIAU7Az8QUQFBckQZJyw8FkU9DD0IPw8APy0HOD8xKzUOEQ0/AS5eQHpzRCpcPDwHJyhSKFhNIhADNywjJx0uGTwJOS4WawcFd31dHz86WitKPjY7DRsGKUZADDMFMSw9JQwsNwxsVUcKfRoHJBlFVCoSCA0JLCsFA0UtUxg4NwlQbz4gDBxtRgpcAzBYHCc2Nm05Hw0PVTY3PwhXITEaI1cpXVEMCFVdB28EPw9GLRwVMCtVJywAJCMcSDgpaggeDzYzCB1sXGNZZQEnMT0NDyAGLTpfMkk6EQsxPi4QCjw3bgQ1VBxYdVFHPDskCSMUAgpTBgw0ACUsQTAkXjISBSRvLhEVcgt9RXsDIhgGLgQZGFc+DTw1Ghg6ESIMNANbDzMICzILAEUKYEYePTQdDDFsGiEaRjUCIUMdDikmIQAPazE9Cy9eUgB8XQ4INF4LQBRQKAYnCUYCBzpXODoHBTUSOQ0MPAEIZnIfLltEHyohBVUrISAXJ0xDSAJbLDg1KwYlAzYxf1VCZxocXBo7CxATOxQOOhE3IyIXIDIsOjUvBSEzAWlme0hTKkU5PxEkAxkWJjdMDitHOx00LwckPjEdGSsBLmZgS0wyRQAUKyktFiI+BD4tPRY6FA5ZJyw+IC8SKUEddwJfXAlYLEoANAIvEQYpPFEcWTkyMxcSJDU5FSArE2taB0VuHSI7FSI8OREBLVslNgtDOyQ+BCkTDBJnUyQbOXlUWEc4PVwhXVE+LAw5KgwhAUEWVSscGQAMJwpcMCYlcw==";

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREFS_NAME = "phisher_donation_prefs";

    @org.jetbrains.annotations.NotNull
    private static java.lang.String adSupportButtonText;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String adSupportUrl;
    private static int cooldownHours;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String currency;

    @org.jetbrains.annotations.NotNull
    private static final java.lang.Object gateLock = null;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String goalDescription;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String goalTitle;
    private static volatile boolean isDialogShowing;
    private static volatile boolean isLaunching;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String primaryButtonText;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String primaryDonateUrl;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String secondaryButtonText;

    @org.jetbrains.annotations.NotNull
    private static java.lang.String secondaryDonateUrl;
    private static double targetAmount;
    private static boolean testMode;
    private static double testProgressAmount;

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2, reason: invalid class name */
    /* JADX INFO: compiled from: DonationManager.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {202, 218, 219, 265}, m = "invokeSuspend", n = {"prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "attempt", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "attempt", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "dynamicTitle", "config", "hasCachedData", "isGoalAchieved"}, nl = {203, 219, 220, 292}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0"}, v = 2)
    @kotlin.jvm.internal.SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,457:1\n40#2,11:458\n40#2,11:469\n40#2,11:480\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n*L\n169#1:458,11\n207#1:469,11\n224#1:480,11\n*E\n"})
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ android.content.Context $appContext;
        final /* synthetic */ java.lang.String $currentMonth;
        final /* synthetic */ java.lang.String $providerName;
        int I$0;
        int I$1;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2$2", f = "DonationManager.kt", i = {0, 0}, l = {187}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240"}, nl = {188}, s = {"L$0", "L$3"}, v = 2)
        @kotlin.jvm.internal.SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,457:1\n40#2,11:458\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2$2\n*L\n189#1:458,11\n*E\n"})
        static final class C00002 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
            final /* synthetic */ java.lang.String $currentMonth;
            final /* synthetic */ android.content.SharedPreferences $prefs;
            final /* synthetic */ java.lang.String $token;
            private /* synthetic */ java.lang.Object L$0;
            java.lang.Object L$1;
            java.lang.Object L$2;
            java.lang.Object L$3;
            int label;

            C00002(java.lang.String r2, android.content.SharedPreferences r3, java.lang.String r4, kotlin.coroutines.Continuation<? super com.phisher98.donation.DonationManager.AnonymousClass2.C00002> r5) {
                    r1 = this;
                    r1.$token = r2
                    r1.$prefs = r3
                    r1.$currentMonth = r4
                    r0 = 2
                    r1.<init>(r0, r5)
                    return
            }

            public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r5, kotlin.coroutines.Continuation<?> r6) {
                    r4 = this;
                    com.phisher98.donation.DonationManager$checkAndShow$2$2 r0 = new com.phisher98.donation.DonationManager$checkAndShow$2$2
                    java.lang.String r1 = r4.$token
                    android.content.SharedPreferences r2 = r4.$prefs
                    java.lang.String r3 = r4.$currentMonth
                    r0.<init>(r1, r2, r3, r6)
                    r0.L$0 = r5
                    kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                    return r0
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                    r1 = this;
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                    java.lang.Object r0 = r1.invoke(r2, r3)
                    return r0
            }

            public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                    r2 = this;
                    kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                    com.phisher98.donation.DonationManager$checkAndShow$2$2 r0 = (com.phisher98.donation.DonationManager.AnonymousClass2.C00002) r0
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    java.lang.Object r0 = r0.invokeSuspend(r1)
                    return r0
            }

            public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                    r14 = this;
                    java.lang.Object r0 = r14.L$0
                    kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r14.label
                    switch(r2) {
                        case 0: goto L28;
                        case 1: goto L15;
                        default: goto Ld;
                    }
                Ld:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L15:
                    r1 = 0
                    java.lang.Object r2 = r14.L$3
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    java.lang.Object r3 = r14.L$2
                    java.lang.String r3 = (java.lang.String) r3
                    java.lang.Object r4 = r14.L$1
                    android.content.SharedPreferences r4 = (android.content.SharedPreferences) r4
                    kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> La3
                    r5 = r2
                    r2 = r15
                    goto L5b
                L28:
                    kotlin.ResultKt.throwOnFailure(r15)
                    java.lang.String r2 = r14.$token
                    android.content.SharedPreferences r4 = r14.$prefs
                    java.lang.String r3 = r14.$currentMonth
                    kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> La3
                    r5 = r0
                    r6 = 0
                    r7 = r2
                    java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch: java.lang.Throwable -> La3
                    boolean r7 = kotlin.text.StringsKt.isBlank(r7)     // Catch: java.lang.Throwable -> La3
                    if (r7 != 0) goto L9c
                    com.phisher98.donation.DonationManager r7 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> La3
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> La3
                    r14.L$0 = r8     // Catch: java.lang.Throwable -> La3
                    r14.L$1 = r4     // Catch: java.lang.Throwable -> La3
                    r14.L$2 = r3     // Catch: java.lang.Throwable -> La3
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch: java.lang.Throwable -> La3
                    r14.L$3 = r8     // Catch: java.lang.Throwable -> La3
                    r8 = 1
                    r14.label = r8     // Catch: java.lang.Throwable -> La3
                    java.lang.Object r2 = com.phisher98.donation.DonationManager.access$fetchBuyMeACoffeeMonthly(r7, r2, r14)     // Catch: java.lang.Throwable -> La3
                    if (r2 != r1) goto L5a
                    return r1
                L5a:
                    r1 = r6
                L5b:
                    kotlin.Pair r2 = (kotlin.Pair) r2     // Catch: java.lang.Throwable -> La3
                    if (r2 == 0) goto L9b
                L60:
                    r6 = 0
                    r7 = 0
                    android.content.SharedPreferences$Editor r8 = r4.edit()     // Catch: java.lang.Throwable -> La3
                    java.lang.String r9 = "editor"
                    kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)     // Catch: java.lang.Throwable -> La3
                    r9 = r8
                    r10 = 0
                    java.lang.String r11 = "phisher_donation_cached_month"
                    android.content.SharedPreferences$Editor r3 = r9.putString(r11, r3)     // Catch: java.lang.Throwable -> La3
                    java.lang.String r11 = "phisher_donation_cached_amount"
                    java.lang.Object r12 = r2.getFirst()     // Catch: java.lang.Throwable -> La3
                    java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> La3
                    double r12 = r12.doubleValue()     // Catch: java.lang.Throwable -> La3
                    float r12 = (float) r12     // Catch: java.lang.Throwable -> La3
                    android.content.SharedPreferences$Editor r3 = r3.putFloat(r11, r12)     // Catch: java.lang.Throwable -> La3
                    java.lang.String r11 = "phisher_donation_cached_supporters"
                    java.lang.Object r12 = r2.getSecond()     // Catch: java.lang.Throwable -> La3
                    java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> La3
                    int r12 = r12.intValue()     // Catch: java.lang.Throwable -> La3
                    r3.putInt(r11, r12)     // Catch: java.lang.Throwable -> La3
                    r8.apply()     // Catch: java.lang.Throwable -> La3
                L9b:
                    r6 = r1
                L9c:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La3
                    kotlin.Result.constructor-impl(r1)     // Catch: java.lang.Throwable -> La3
                    goto Lad
                La3:
                    r1 = move-exception
                    kotlin.Result$Companion r2 = kotlin.Result.Companion
                    java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
                    kotlin.Result.constructor-impl(r1)
                Lad:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
            }
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2$5", f = "DonationManager.kt", i = {0, 0}, l = {272}, m = "invokeSuspend", n = {"currentActivity", "i"}, nl = {273}, s = {"L$0", "I$0"}, v = 2)
        static final class AnonymousClass5 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
            final /* synthetic */ android.content.Context $appContext;
            final /* synthetic */ com.phisher98.donation.DonationConfig $config;
            int I$0;
            java.lang.Object L$0;
            int label;

            AnonymousClass5(android.content.Context r2, com.phisher98.donation.DonationConfig r3, kotlin.coroutines.Continuation<? super com.phisher98.donation.DonationManager.AnonymousClass2.AnonymousClass5> r4) {
                    r1 = this;
                    r1.$appContext = r2
                    r1.$config = r3
                    r0 = 2
                    r1.<init>(r0, r4)
                    return
            }

            static final kotlin.Unit invokeSuspend$lambda$0() {
                    com.phisher98.donation.DonationManager r0 = com.phisher98.donation.DonationManager.INSTANCE
                    r1 = 0
                    r0.setDialogShowing(r1)
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
            }

            public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r4, kotlin.coroutines.Continuation<?> r5) {
                    r3 = this;
                    com.phisher98.donation.DonationManager$checkAndShow$2$5 r0 = new com.phisher98.donation.DonationManager$checkAndShow$2$5
                    android.content.Context r1 = r3.$appContext
                    com.phisher98.donation.DonationConfig r2 = r3.$config
                    r0.<init>(r1, r2, r5)
                    kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                    return r0
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                    r1 = this;
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                    java.lang.Object r0 = r1.invoke(r2, r3)
                    return r0
            }

            public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                    r2 = this;
                    kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                    com.phisher98.donation.DonationManager$checkAndShow$2$5 r0 = (com.phisher98.donation.DonationManager.AnonymousClass2.AnonymousClass5) r0
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    java.lang.Object r0 = r0.invokeSuspend(r1)
                    return r0
            }

            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    r10 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r10.label
                    r2 = 0
                    r3 = 1
                    switch(r1) {
                        case 0: goto L1e;
                        case 1: goto L13;
                        default: goto Lb;
                    }
                Lb:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L13:
                    int r1 = r10.I$0
                    java.lang.Object r4 = r10.L$0
                    androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
                    kotlin.ResultKt.throwOnFailure(r11)
                    r5 = r10
                    goto L71
                L1e:
                    kotlin.ResultKt.throwOnFailure(r11)
                    com.phisher98.donation.DonationManager r1 = com.phisher98.donation.DonationManager.INSTANCE
                    boolean r1 = r1.isDialogShowing()
                    if (r1 == 0) goto L2c
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                L2c:
                    com.lagradost.cloudstream3.CommonActivity r1 = com.lagradost.cloudstream3.CommonActivity.INSTANCE
                    android.app.Activity r1 = r1.getActivity()
                    boolean r4 = r1 instanceof androidx.appcompat.app.AppCompatActivity
                    if (r4 == 0) goto L39
                    androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
                    goto L3a
                L39:
                    r1 = r2
                L3a:
                    if (r1 == 0) goto L4b
                    boolean r4 = r1.isFinishing()
                    if (r4 != 0) goto L4b
                    boolean r4 = r1.isDestroyed()
                    if (r4 == 0) goto L49
                    goto L4b
                L49:
                    r5 = r10
                    goto L95
                L4b:
                    r4 = 0
                    r5 = r4
                    r4 = r1
                    r1 = r5
                    r5 = r10
                L50:
                    r6 = 6
                    if (r1 >= r6) goto L94
                    kotlin.time.Duration$Companion r6 = kotlin.time.Duration.Companion
                    r6 = 500(0x1f4, float:7.0E-43)
                    kotlin.time.DurationUnit r7 = kotlin.time.DurationUnit.MILLISECONDS
                    long r6 = kotlin.time.DurationKt.toDuration(r6, r7)
                    r8 = r5
                    kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                    java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                    r5.L$0 = r9
                    r5.I$0 = r1
                    r5.label = r3
                    java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay-VtjQ1oo(r6, r8)
                    if (r6 != r0) goto L71
                    return r0
                L71:
                    com.lagradost.cloudstream3.CommonActivity r6 = com.lagradost.cloudstream3.CommonActivity.INSTANCE
                    android.app.Activity r6 = r6.getActivity()
                    boolean r7 = r6 instanceof androidx.appcompat.app.AppCompatActivity
                    if (r7 == 0) goto L7e
                    androidx.appcompat.app.AppCompatActivity r6 = (androidx.appcompat.app.AppCompatActivity) r6
                    goto L7f
                L7e:
                    r6 = r2
                L7f:
                    r4 = r6
                    if (r4 == 0) goto L91
                    boolean r6 = r4.isFinishing()
                    if (r6 != 0) goto L91
                    boolean r6 = r4.isDestroyed()
                    if (r6 == 0) goto L8f
                    goto L91
                L8f:
                    r1 = r4
                    goto L95
                L91:
                    int r1 = r1 + 1
                    goto L50
                L94:
                    r1 = r4
                L95:
                    if (r1 == 0) goto Leb
                    boolean r0 = r1.isFinishing()
                    if (r0 != 0) goto Leb
                    boolean r0 = r1.isDestroyed()
                    if (r0 == 0) goto La4
                    goto Leb
                La4:
                    androidx.fragment.app.FragmentManager r0 = r1.getSupportFragmentManager()
                    boolean r2 = r0.isDestroyed()
                    if (r2 != 0) goto Le8
                    java.lang.String r2 = "phisher_donation_floating_dialog"
                    androidx.fragment.app.Fragment r4 = r0.findFragmentByTag(r2)
                    if (r4 == 0) goto Lb7
                    goto Le8
                Lb7:
                    com.phisher98.donation.DonationManager r4 = com.phisher98.donation.DonationManager.INSTANCE
                    r4.setDialogShowing(r3)
                    com.phisher98.donation.DonationManager r3 = com.phisher98.donation.DonationManager.INSTANCE
                    boolean r3 = r3.getTestMode()
                    if (r3 != 0) goto Lcb
                    com.phisher98.donation.DonationManager r3 = com.phisher98.donation.DonationManager.INSTANCE
                    android.content.Context r4 = r5.$appContext
                    com.phisher98.donation.DonationManager.access$recordShown(r3, r4)
                Lcb:
                    com.phisher98.donation.DonationDialogFragment r3 = new com.phisher98.donation.DonationDialogFragment
                    com.phisher98.donation.DonationConfig r4 = r5.$config
                    com.phisher98.donation.DonationManager$checkAndShow$2$5$$ExternalSyntheticLambda0 r6 = new com.phisher98.donation.DonationManager$checkAndShow$2$5$$ExternalSyntheticLambda0
                    r6.<init>()
                    r3.<init>(r4, r6)
                    androidx.fragment.app.FragmentTransaction r4 = r0.beginTransaction()
                    r6 = r3
                    androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
                    androidx.fragment.app.FragmentTransaction r2 = r4.add(r6, r2)
                    r2.commitAllowingStateLoss()
                    kotlin.Unit r2 = kotlin.Unit.INSTANCE
                    return r2
                Le8:
                    kotlin.Unit r2 = kotlin.Unit.INSTANCE
                    return r2
                Leb:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
            }
        }

        AnonymousClass2(android.content.Context r2, java.lang.String r3, java.lang.String r4, kotlin.coroutines.Continuation<? super com.phisher98.donation.DonationManager.AnonymousClass2> r5) {
                r1 = this;
                r1.$appContext = r2
                r1.$currentMonth = r3
                r1.$providerName = r4
                r0 = 2
                r1.<init>(r0, r5)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r5, kotlin.coroutines.Continuation<?> r6) {
                r4 = this;
                com.phisher98.donation.DonationManager$checkAndShow$2 r0 = new com.phisher98.donation.DonationManager$checkAndShow$2
                android.content.Context r1 = r4.$appContext
                java.lang.String r2 = r4.$currentMonth
                java.lang.String r3 = r4.$providerName
                r0.<init>(r1, r2, r3, r6)
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                r1 = this;
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r0 = r1.invoke(r2, r3)
                return r0
        }

        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.donation.DonationManager$checkAndShow$2 r0 = (com.phisher98.donation.DonationManager.AnonymousClass2) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
                r40 = this;
                r1 = r40
                java.lang.String r0 = ""
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                java.lang.String r6 = "editor"
                java.lang.String r9 = "phisher_donation_cached_supporters"
                java.lang.String r10 = "phisher_donation_cached_amount"
                r11 = 0
                java.lang.String r13 = "phisher_donation_cached_month"
                switch(r3) {
                    case 0: goto Lcd;
                    case 1: goto La5;
                    case 2: goto L76;
                    case 3: goto L47;
                    case 4: goto L1f;
                    default: goto L17;
                }
            L17:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1f:
                int r0 = r1.I$0
                boolean r2 = r1.Z$0
                java.lang.Object r3 = r1.L$6
                com.phisher98.donation.DonationConfig r3 = (com.phisher98.donation.DonationConfig) r3
                java.lang.Object r4 = r1.L$5
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r5 = r1.L$4
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r6 = r1.L$3
                kotlin.jvm.internal.Ref$IntRef r6 = (kotlin.jvm.internal.Ref.IntRef) r6
                java.lang.Object r7 = r1.L$2
                kotlin.jvm.internal.Ref$DoubleRef r7 = (kotlin.jvm.internal.Ref.DoubleRef) r7
                java.lang.Object r8 = r1.L$1
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r9 = r1.L$0
                android.content.SharedPreferences r9 = (android.content.SharedPreferences) r9
                kotlin.ResultKt.throwOnFailure(r41)     // Catch: java.lang.Throwable -> Lc7
                r16 = r41
                r12 = r1
                goto L43f
            L47:
                int r0 = r1.I$1
                int r3 = r1.I$0
                boolean r15 = r1.Z$0
                java.lang.Object r4 = r1.L$4
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r5 = r1.L$3
                kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
                java.lang.Object r8 = r1.L$2
                kotlin.jvm.internal.Ref$DoubleRef r8 = (kotlin.jvm.internal.Ref.DoubleRef) r8
                java.lang.Object r7 = r1.L$1
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r14 = r1.L$0
                android.content.SharedPreferences r14 = (android.content.SharedPreferences) r14
                kotlin.ResultKt.throwOnFailure(r41)     // Catch: java.lang.Throwable -> Lc7
                r18 = r10
                r22 = r11
                r10 = r15
                r12 = r1
                r15 = r9
                r1 = r41
                r9 = r8
                r8 = r7
                r7 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                goto L292
            L76:
                int r0 = r1.I$1
                int r3 = r1.I$0
                boolean r4 = r1.Z$0
                java.lang.Object r5 = r1.L$4
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r7 = r1.L$3
                kotlin.jvm.internal.Ref$IntRef r7 = (kotlin.jvm.internal.Ref.IntRef) r7
                java.lang.Object r8 = r1.L$2
                kotlin.jvm.internal.Ref$DoubleRef r8 = (kotlin.jvm.internal.Ref.DoubleRef) r8
                java.lang.Object r14 = r1.L$1
                java.lang.String r14 = (java.lang.String) r14
                java.lang.Object r15 = r1.L$0
                android.content.SharedPreferences r15 = (android.content.SharedPreferences) r15
                kotlin.ResultKt.throwOnFailure(r41)     // Catch: java.lang.Throwable -> Lc7
                r18 = r9
                r9 = r4
                r4 = r5
                r5 = r7
                r7 = r14
                r14 = r15
                r15 = r18
                r18 = r10
                r22 = r11
                r12 = r1
                r1 = r41
                goto L25b
            La5:
                int r0 = r1.I$0
                boolean r3 = r1.Z$0
                java.lang.Object r4 = r1.L$4
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r5 = r1.L$3
                kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
                java.lang.Object r7 = r1.L$2
                kotlin.jvm.internal.Ref$DoubleRef r7 = (kotlin.jvm.internal.Ref.DoubleRef) r7
                java.lang.Object r8 = r1.L$1
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r14 = r1.L$0
                android.content.SharedPreferences r14 = (android.content.SharedPreferences) r14
                kotlin.ResultKt.throwOnFailure(r41)     // Catch: java.lang.Throwable -> Lc7
                r22 = r11
                r15 = 1
                r11 = r41
                goto L199
            Lc7:
                r0 = move-exception
                r16 = r41
                r12 = r1
                goto L44b
            Lcd:
                kotlin.ResultKt.throwOnFailure(r41)
                com.phisher98.donation.DonationManager r3 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L446
                android.content.Context r4 = r1.$appContext     // Catch: java.lang.Throwable -> L446
                android.content.SharedPreferences r3 = com.phisher98.donation.DonationManager.access$getPrefs(r3, r4)     // Catch: java.lang.Throwable -> L446
                r14 = r3
                java.lang.String r3 = r14.getString(r13, r0)     // Catch: java.lang.Throwable -> L446
                if (r3 != 0) goto Le1
                goto Le2
            Le1:
                r0 = r3
            Le2:
                r8 = r0
                java.lang.String r0 = r1.$currentMonth     // Catch: java.lang.Throwable -> L446
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)     // Catch: java.lang.Throwable -> L446
                r3 = r0
                kotlin.jvm.internal.Ref$DoubleRef r0 = new kotlin.jvm.internal.Ref$DoubleRef     // Catch: java.lang.Throwable -> L446
                r0.<init>()     // Catch: java.lang.Throwable -> L446
                r7 = r0
                kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Throwable -> L446
                r0.<init>()     // Catch: java.lang.Throwable -> L446
                r5 = r0
                r0 = 0
                if (r3 != 0) goto L12a
                r7.element = r11     // Catch: java.lang.Throwable -> Lc7
                r4 = 0
                r5.element = r4     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r4 = r1.$currentMonth     // Catch: java.lang.Throwable -> Lc7
                r15 = r14
                r18 = 0
                r19 = 0
                android.content.SharedPreferences$Editor r20 = r15.edit()     // Catch: java.lang.Throwable -> Lc7
                r21 = r20
                r22 = r11
                r11 = r21
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r6)     // Catch: java.lang.Throwable -> Lc7
                r12 = r11
                r20 = 0
                android.content.SharedPreferences$Editor r4 = r12.putString(r13, r4)     // Catch: java.lang.Throwable -> Lc7
                android.content.SharedPreferences$Editor r0 = r4.putFloat(r10, r0)     // Catch: java.lang.Throwable -> Lc7
                r4 = 0
                r0.putInt(r9, r4)     // Catch: java.lang.Throwable -> Lc7
                r11.apply()     // Catch: java.lang.Throwable -> Lc7
                goto L13a
            L12a:
                r22 = r11
                float r0 = r14.getFloat(r10, r0)     // Catch: java.lang.Throwable -> L446
                double r11 = (double) r0     // Catch: java.lang.Throwable -> L446
                r7.element = r11     // Catch: java.lang.Throwable -> L446
                r4 = 0
                int r0 = r14.getInt(r9, r4)     // Catch: java.lang.Throwable -> L446
                r5.element = r0     // Catch: java.lang.Throwable -> L446
            L13a:
                com.phisher98.donation.DonationManager r0 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L446
                java.lang.String r0 = com.phisher98.donation.DonationManager.access$getDecryptedBmcToken(r0)     // Catch: java.lang.Throwable -> L446
                r4 = r0
                if (r3 == 0) goto L16e
                kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> Lc7
                kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch: java.lang.Throwable -> Lc7
                kotlinx.coroutines.CoroutineScope r24 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)     // Catch: java.lang.Throwable -> Lc7
                com.phisher98.donation.DonationManager$checkAndShow$2$2 r0 = new com.phisher98.donation.DonationManager$checkAndShow$2$2     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r6 = r1.$currentMonth     // Catch: java.lang.Throwable -> Lc7
                r9 = 0
                r0.<init>(r4, r14, r6, r9)     // Catch: java.lang.Throwable -> Lc7
                r27 = r0
                kotlin.jvm.functions.Function2 r27 = (kotlin.jvm.functions.Function2) r27     // Catch: java.lang.Throwable -> Lc7
                r28 = 3
                r29 = 0
                r25 = 0
                r26 = 0
                kotlinx.coroutines.BuildersKt.launch$default(r24, r25, r26, r27, r28, r29)     // Catch: java.lang.Throwable -> Lc7
                r16 = r41
                r12 = r1
                r0 = r2
                r2 = r3
                r6 = r5
                r9 = r14
                r5 = r4
                goto L34a
            L16e:
                r0 = 0
                r11 = r4
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch: java.lang.Throwable -> L446
                boolean r11 = kotlin.text.StringsKt.isBlank(r11)     // Catch: java.lang.Throwable -> L446
                if (r11 != 0) goto L1fd
                com.phisher98.donation.DonationManager r11 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L1f6
                r12 = r1
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch: java.lang.Throwable -> L1f6
                r1.L$0 = r14     // Catch: java.lang.Throwable -> L1f6
                java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch: java.lang.Throwable -> L1f6
                r1.L$1 = r15     // Catch: java.lang.Throwable -> L1f6
                r1.L$2 = r7     // Catch: java.lang.Throwable -> L1f6
                r1.L$3 = r5     // Catch: java.lang.Throwable -> L1f6
                r1.L$4 = r4     // Catch: java.lang.Throwable -> L1f6
                r1.Z$0 = r3     // Catch: java.lang.Throwable -> L1f6
                r1.I$0 = r0     // Catch: java.lang.Throwable -> L1f6
                r15 = 1
                r1.label = r15     // Catch: java.lang.Throwable -> L1f6
                java.lang.Object r11 = com.phisher98.donation.DonationManager.access$fetchBuyMeACoffeeMonthly(r11, r4, r12)     // Catch: java.lang.Throwable -> L1f6
                if (r11 != r2) goto L199
                return r2
            L199:
                kotlin.Pair r11 = (kotlin.Pair) r11     // Catch: java.lang.Throwable -> L1f6
                if (r11 == 0) goto L1f1
                java.lang.Object r12 = r11.getFirst()     // Catch: java.lang.Throwable -> L1f6
                java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> L1f6
                r16 = r2
                r18 = r3
                double r2 = r12.doubleValue()     // Catch: java.lang.Throwable -> L1f6
                r7.element = r2     // Catch: java.lang.Throwable -> L1f6
                java.lang.Object r2 = r11.getSecond()     // Catch: java.lang.Throwable -> L1f6
                java.lang.Number r2 = (java.lang.Number) r2     // Catch: java.lang.Throwable -> L1f6
                int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L1f6
                r5.element = r2     // Catch: java.lang.Throwable -> L1f6
                r0 = 1
                java.lang.String r2 = r1.$currentMonth     // Catch: java.lang.Throwable -> L1f6
                r3 = r14
                r12 = 0
                r19 = 0
                android.content.SharedPreferences$Editor r20 = r3.edit()     // Catch: java.lang.Throwable -> L1f6
                r21 = r20
                r15 = r21
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r6)     // Catch: java.lang.Throwable -> L1f6
                r21 = r15
                r24 = 0
                r25 = r0
                r0 = r21
                android.content.SharedPreferences$Editor r2 = r0.putString(r13, r2)     // Catch: java.lang.Throwable -> L1f6
                r21 = r0
                double r0 = r7.element     // Catch: java.lang.Throwable -> L1f6
                float r0 = (float) r0     // Catch: java.lang.Throwable -> L1f6
                android.content.SharedPreferences$Editor r0 = r2.putFloat(r10, r0)     // Catch: java.lang.Throwable -> L1f6
                int r1 = r5.element     // Catch: java.lang.Throwable -> L1f6
                r0.putInt(r9, r1)     // Catch: java.lang.Throwable -> L1f6
                r15.apply()     // Catch: java.lang.Throwable -> L1f6
                r3 = r18
                r0 = r25
                goto L1ff
            L1f1:
                r16 = r2
                r18 = r3
                goto L1ff
            L1f6:
                r0 = move-exception
                r12 = r40
                r16 = r41
                goto L44b
            L1fd:
                r16 = r2
            L1ff:
                if (r0 != 0) goto L33f
                com.phisher98.donation.DonationManager r1 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L446
                double r1 = r1.getTestProgressAmount()     // Catch: java.lang.Throwable -> L446
                int r11 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
                if (r11 > 0) goto L33f
                r1 = 1
                r12 = r40
                r2 = r1
                r11 = r8
                r1 = r41
                r8 = r7
                r7 = r5
                r5 = r4
                r4 = r3
                r3 = r16
            L218:
                r15 = 4
                if (r2 >= r15) goto L326
                kotlin.time.Duration$Companion r15 = kotlin.time.Duration.Companion     // Catch: java.lang.Throwable -> L31a
                r15 = r9
                r18 = r10
                long r9 = (long) r2
                r24 = 3000(0xbb8, double:1.482E-320)
                long r9 = r9 * r24
                r41 = r1
                kotlin.time.DurationUnit r1 = kotlin.time.DurationUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L321
                long r9 = kotlin.time.DurationKt.toDuration(r9, r1)     // Catch: java.lang.Throwable -> L321
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L321
                r12.L$0 = r14     // Catch: java.lang.Throwable -> L321
                r16 = r11
                java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)     // Catch: java.lang.Throwable -> L321
                r12.L$1 = r11     // Catch: java.lang.Throwable -> L321
                r12.L$2 = r8     // Catch: java.lang.Throwable -> L321
                r12.L$3 = r7     // Catch: java.lang.Throwable -> L321
                r12.L$4 = r5     // Catch: java.lang.Throwable -> L321
                r12.Z$0 = r4     // Catch: java.lang.Throwable -> L321
                r12.I$0 = r0     // Catch: java.lang.Throwable -> L321
                r12.I$1 = r2     // Catch: java.lang.Throwable -> L321
                r11 = 2
                r12.label = r11     // Catch: java.lang.Throwable -> L321
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay-VtjQ1oo(r9, r1)     // Catch: java.lang.Throwable -> L321
                if (r1 != r3) goto L250
                return r3
            L250:
                r1 = r3
                r3 = r0
                r0 = r2
                r2 = r1
                r9 = r4
                r4 = r5
                r5 = r7
                r7 = r16
                r1 = r41
            L25b:
                r10 = r4
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch: java.lang.Throwable -> L31a
                boolean r10 = kotlin.text.StringsKt.isBlank(r10)     // Catch: java.lang.Throwable -> L31a
                if (r10 != 0) goto L2a1
                com.phisher98.donation.DonationManager r10 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L31a
                r11 = r12
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L31a
                r12.L$0 = r14     // Catch: java.lang.Throwable -> L31a
                r41 = r1
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Throwable -> L321
                r12.L$1 = r1     // Catch: java.lang.Throwable -> L321
                r12.L$2 = r8     // Catch: java.lang.Throwable -> L321
                r12.L$3 = r5     // Catch: java.lang.Throwable -> L321
                r12.L$4 = r4     // Catch: java.lang.Throwable -> L321
                r12.Z$0 = r9     // Catch: java.lang.Throwable -> L321
                r12.I$0 = r3     // Catch: java.lang.Throwable -> L321
                r12.I$1 = r0     // Catch: java.lang.Throwable -> L321
                r1 = 3
                r12.label = r1     // Catch: java.lang.Throwable -> L321
                java.lang.Object r1 = com.phisher98.donation.DonationManager.access$fetchBuyMeACoffeeMonthly(r10, r4, r11)     // Catch: java.lang.Throwable -> L321
                if (r1 != r2) goto L289
                return r2
            L289:
                r10 = r9
                r9 = r8
                r8 = r7
                r7 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r41
            L292:
                kotlin.Pair r1 = (kotlin.Pair) r1     // Catch: java.lang.Throwable -> L29c
                r11 = r8
                r8 = r9
                r9 = r1
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r10
                goto L2a8
            L29c:
                r0 = move-exception
                r16 = r2
                goto L44b
            L2a1:
                r41 = r1
                r11 = r7
                r7 = r5
                r5 = r4
                r4 = r9
                r9 = 0
            L2a8:
                if (r9 == 0) goto L30a
                java.lang.Object r10 = r9.getFirst()     // Catch: java.lang.Throwable -> L305
                java.lang.Number r10 = (java.lang.Number) r10     // Catch: java.lang.Throwable -> L305
                r41 = r0
                r16 = r1
                double r0 = r10.doubleValue()     // Catch: java.lang.Throwable -> L444
                r8.element = r0     // Catch: java.lang.Throwable -> L444
                java.lang.Object r0 = r9.getSecond()     // Catch: java.lang.Throwable -> L444
                java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L444
                int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L444
                r7.element = r0     // Catch: java.lang.Throwable -> L444
                r0 = 1
                java.lang.String r1 = r12.$currentMonth     // Catch: java.lang.Throwable -> L444
                r3 = r14
                r10 = 0
                r19 = 0
                android.content.SharedPreferences$Editor r21 = r3.edit()     // Catch: java.lang.Throwable -> L444
                r24 = r21
                r21 = r0
                r0 = r24
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)     // Catch: java.lang.Throwable -> L444
                r6 = r0
                r24 = 0
                android.content.SharedPreferences$Editor r1 = r6.putString(r13, r1)     // Catch: java.lang.Throwable -> L444
                r25 = r2
                r26 = r3
                double r2 = r8.element     // Catch: java.lang.Throwable -> L444
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L444
                r3 = r18
                android.content.SharedPreferences$Editor r1 = r1.putFloat(r3, r2)     // Catch: java.lang.Throwable -> L444
                int r2 = r7.element     // Catch: java.lang.Throwable -> L444
                r1.putInt(r15, r2)     // Catch: java.lang.Throwable -> L444
                r0.apply()     // Catch: java.lang.Throwable -> L444
                r3 = r4
                r4 = r5
                r5 = r7
                r7 = r8
                r8 = r11
                r0 = r21
                r2 = r25
                goto L333
            L305:
                r0 = move-exception
                r16 = r1
                goto L44b
            L30a:
                r41 = r0
                r16 = r1
                r25 = r2
                int r2 = r41 + 1
                r0 = r3
                r9 = r15
                r10 = r18
                r3 = r25
                goto L218
            L31a:
                r0 = move-exception
                r41 = r1
                r16 = r41
                goto L44b
            L321:
                r0 = move-exception
                r16 = r41
                goto L44b
            L326:
                r41 = r1
                r16 = r11
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r7
                r7 = r8
                r8 = r16
                r16 = r41
            L333:
                if (r0 != 0) goto L345
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r2 = com.phisher98.donation.DonationManager.INSTANCE
                r17 = 0
                com.phisher98.donation.DonationManager.access$setLaunching$p(r17)
                return r1
            L33f:
                r12 = r40
                r2 = r16
                r16 = r41
            L345:
                r0 = r2
                r2 = r3
                r6 = r5
                r9 = r14
                r5 = r4
            L34a:
                com.phisher98.donation.DonationManager r1 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                double r3 = r1.getTestProgressAmount()     // Catch: java.lang.Throwable -> L444
                int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
                if (r1 <= 0) goto L363
                com.phisher98.donation.DonationManager r1 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                double r3 = r1.getTestProgressAmount()     // Catch: java.lang.Throwable -> L444
                r7.element = r3     // Catch: java.lang.Throwable -> L444
                int r1 = r6.element     // Catch: java.lang.Throwable -> L444
                if (r1 != 0) goto L363
                r1 = 3
                r6.element = r1     // Catch: java.lang.Throwable -> L444
            L363:
                com.phisher98.donation.DonationManager r1 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                double r3 = r1.getTargetAmount()     // Catch: java.lang.Throwable -> L444
                int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
                if (r1 <= 0) goto L37c
                double r3 = r7.element     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r1 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                double r10 = r1.getTargetAmount()     // Catch: java.lang.Throwable -> L444
                int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                if (r1 < 0) goto L37c
                r20 = 1
                goto L37e
            L37c:
                r20 = 0
            L37e:
                r1 = r20
                if (r1 == 0) goto L385
                java.lang.String r3 = "Goal Achieved for Phisher Repo!"
                goto L38b
            L385:
                com.phisher98.donation.DonationManager r3 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r3 = r3.getGoalTitle()     // Catch: java.lang.Throwable -> L444
            L38b:
                r22 = r3
                com.phisher98.donation.DonationConfig r18 = new com.phisher98.donation.DonationConfig     // Catch: java.lang.Throwable -> L444
                java.lang.String r3 = r12.$providerName     // Catch: java.lang.Throwable -> L444
                java.lang.String r4 = r12.$currentMonth     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r10 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r23 = r10.getGoalDescription()     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r10 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r24 = r10.getCurrency()     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r10 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                double r25 = r10.getTargetAmount()     // Catch: java.lang.Throwable -> L444
                double r10 = r7.element     // Catch: java.lang.Throwable -> L444
                int r13 = r6.element     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r30 = r14.getPrimaryDonateUrl()     // Catch: java.lang.Throwable -> L444
                if (r1 == 0) goto L3b6
                java.lang.String r14 = "☕ Send Extra Love"
                goto L3bc
            L3b6:
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r14 = r14.getPrimaryButtonText()     // Catch: java.lang.Throwable -> L444
            L3bc:
                r31 = r14
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r32 = r14.getSecondaryDonateUrl()     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r33 = r14.getSecondaryButtonText()     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r34 = r14.getAdSupportUrl()     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                java.lang.String r35 = r14.getAdSupportButtonText()     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager r14 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L444
                int r36 = r14.getCooldownHours()     // Catch: java.lang.Throwable -> L444
                r38 = 65536(0x10000, float:9.1835E-41)
                r39 = 0
                r19 = 1
                r37 = 0
                r20 = r3
                r21 = r4
                r27 = r10
                r29 = r13
                r18.<init>(r19, r20, r21, r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)     // Catch: java.lang.Throwable -> L444
                r3 = r18
                kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L444
                kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4     // Catch: java.lang.Throwable -> L444
                com.phisher98.donation.DonationManager$checkAndShow$2$5 r10 = new com.phisher98.donation.DonationManager$checkAndShow$2$5     // Catch: java.lang.Throwable -> L444
                android.content.Context r11 = r12.$appContext     // Catch: java.lang.Throwable -> L444
                r13 = 0
                r10.<init>(r11, r3, r13)     // Catch: java.lang.Throwable -> L444
                kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch: java.lang.Throwable -> L444
                r11 = r12
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)     // Catch: java.lang.Throwable -> L444
                r12.L$0 = r13     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch: java.lang.Throwable -> L444
                r12.L$1 = r13     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Throwable -> L444
                r12.L$2 = r13     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch: java.lang.Throwable -> L444
                r12.L$3 = r13     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch: java.lang.Throwable -> L444
                r12.L$4 = r13     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)     // Catch: java.lang.Throwable -> L444
                r12.L$5 = r13     // Catch: java.lang.Throwable -> L444
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)     // Catch: java.lang.Throwable -> L444
                r12.L$6 = r13     // Catch: java.lang.Throwable -> L444
                r12.Z$0 = r2     // Catch: java.lang.Throwable -> L444
                r12.I$0 = r1     // Catch: java.lang.Throwable -> L444
                r15 = 4
                r12.label = r15     // Catch: java.lang.Throwable -> L444
                java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r4, r10, r11)     // Catch: java.lang.Throwable -> L444
                if (r4 != r0) goto L43c
                return r0
            L43c:
                r0 = r1
                r4 = r22
            L43f:
                com.phisher98.donation.DonationManager r0 = com.phisher98.donation.DonationManager.INSTANCE
                r17 = 0
                goto L44f
            L444:
                r0 = move-exception
                goto L44b
            L446:
                r0 = move-exception
                r12 = r40
                r16 = r41
            L44b:
                com.phisher98.donation.DonationManager r0 = com.phisher98.donation.DonationManager.INSTANCE
                r17 = 0
            L44f:
                com.phisher98.donation.DonationManager.access$setLaunching$p(r17)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1, reason: invalid class name */
    /* JADX INFO: compiled from: DonationManager.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.donation.DonationManager", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {333, 345, 400}, m = "fetchBuyMeACoffeeMonthly", n = {"accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "isoFormat", "page", "res", "$this$fetchBuyMeACoffeeMonthly_u24lambda_u245", "currentYear", "currentMonth", "hasMore", "attempt", "accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "isoFormat", "page", "res", "currentYear", "currentMonth", "hasMore", "attempt", "accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "isoFormat", "page", "$this$fetchBuyMeACoffeeMonthly_u24lambda_u247", "currentYear", "currentMonth", "hasMore"}, nl = {342, 346, 410}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        java.lang.Object L$8;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.donation.DonationManager this$0;

        AnonymousClass1(com.phisher98.donation.DonationManager r1, kotlin.coroutines.Continuation<? super com.phisher98.donation.DonationManager.AnonymousClass1> r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
                r3 = this;
                r3.result = r4
                int r0 = r3.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 | r1
                r3.label = r0
                com.phisher98.donation.DonationManager r0 = r3.this$0
                r1 = 0
                r2 = r3
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r0 = com.phisher98.donation.DonationManager.access$fetchBuyMeACoffeeMonthly(r0, r1, r2)
                return r0
        }
    }

    static {
            com.phisher98.donation.DonationManager r0 = new com.phisher98.donation.DonationManager
            r0.<init>()
            com.phisher98.donation.DonationManager.INSTANCE = r0
            java.lang.String r0 = "https://buymeacoffee.com/phisher98"
            com.phisher98.donation.DonationManager.primaryDonateUrl = r0
            java.lang.String r0 = "☕ Keep It Alive"
            com.phisher98.donation.DonationManager.primaryButtonText = r0
            java.lang.String r0 = ""
            com.phisher98.donation.DonationManager.secondaryDonateUrl = r0
            java.lang.String r0 = "⚡ Donate via UPI / Other"
            com.phisher98.donation.DonationManager.secondaryButtonText = r0
            java.lang.String r0 = "https://omg10.com/4/11733824"
            com.phisher98.donation.DonationManager.adSupportUrl = r0
            java.lang.String r0 = "🎬 Can't donate? Watch an Ad to Support ↗"
            com.phisher98.donation.DonationManager.adSupportButtonText = r0
            r0 = 4636737291354636288(0x4059000000000000, double:100.0)
            com.phisher98.donation.DonationManager.targetAmount = r0
            java.lang.String r0 = "$"
            com.phisher98.donation.DonationManager.currency = r0
            java.lang.String r0 = "Help Keep Phisher Repo Alive"
            com.phisher98.donation.DonationManager.goalTitle = r0
            java.lang.String r0 = "Support us to keep this extension maintained! Reaching the goal means faster updates and active maintenance. If not, updates will be slow, and the extension could become dead over time."
            com.phisher98.donation.DonationManager.goalDescription = r0
            r0 = 24
            com.phisher98.donation.DonationManager.cooldownHours = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            com.phisher98.donation.DonationManager.gateLock = r0
            return
    }

    private DonationManager() {
            r0 = this;
            r0.<init>()
            return
    }

    public static final /* synthetic */ java.lang.Object access$fetchBuyMeACoffeeMonthly(com.phisher98.donation.DonationManager r1, java.lang.String r2, kotlin.coroutines.Continuation r3) {
            java.lang.Object r0 = r1.fetchBuyMeACoffeeMonthly(r2, r3)
            return r0
    }

    public static final /* synthetic */ java.lang.String access$getDecryptedBmcToken(com.phisher98.donation.DonationManager r1) {
            java.lang.String r0 = r1.getDecryptedBmcToken()
            return r0
    }

    public static final /* synthetic */ android.content.SharedPreferences access$getPrefs(com.phisher98.donation.DonationManager r1, android.content.Context r2) {
            android.content.SharedPreferences r0 = r1.getPrefs(r2)
            return r0
    }

    public static final /* synthetic */ void access$recordShown(com.phisher98.donation.DonationManager r0, android.content.Context r1) {
            r0.recordShown(r1)
            return
    }

    public static final /* synthetic */ void access$setLaunching$p(boolean r0) {
            com.phisher98.donation.DonationManager.isLaunching = r0
            return
    }

    public static /* synthetic */ void checkAndShow$default(com.phisher98.donation.DonationManager r0, java.lang.String r1, int r2, java.lang.Object r3) {
            r2 = r2 & 1
            if (r2 == 0) goto L6
            java.lang.String r1 = ""
        L6:
            r0.checkAndShow(r1)
            return
    }

    private final java.lang.Object fetchBuyMeACoffeeMonthly(java.lang.String r75, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Double, java.lang.Integer>> r76) {
            r74 = this;
            r1 = r76
            java.lang.String r2 = "is_paused"
            java.lang.String r3 = "subscription_is_cancelled"
            java.lang.String r4 = "is_refunded"
            boolean r0 = r1 instanceof com.phisher98.donation.DonationManager.AnonymousClass1
            if (r0 == 0) goto L1e
            r0 = r1
            com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1 r0 = (com.phisher98.donation.DonationManager.AnonymousClass1) r0
            int r5 = r0.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L1e
            int r5 = r0.label
            int r5 = r5 - r6
            r0.label = r5
            r5 = r74
            goto L25
        L1e:
            com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1 r0 = new com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1
            r5 = r74
            r0.<init>(r5, r1)
        L25:
            r6 = r0
            java.lang.Object r7 = r6.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            java.lang.String r9 = "Accept"
            java.lang.String r10 = "Content-Type"
            java.lang.String r11 = "Bearer "
            java.lang.String r12 = "Authorization"
            java.lang.String r14 = "data"
            java.lang.String r15 = "null"
            java.lang.String r13 = "application/json"
            java.lang.String r19 = "UTC"
            java.lang.String r1 = ""
            r23 = 0
            switch(r0) {
                case 0: goto L1ae;
                case 1: goto L11d;
                case 2: goto L9d;
                case 3: goto L4d;
                default: goto L45;
            }
        L45:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4d:
            r0 = 0
            int r4 = r6.I$2
            int r8 = r6.I$1
            int r9 = r6.I$0
            java.lang.Object r10 = r6.L$7
            com.phisher98.donation.DonationManager r10 = (com.phisher98.donation.DonationManager) r10
            java.lang.Object r11 = r6.L$6
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r6.L$5
            java.text.SimpleDateFormat r12 = (java.text.SimpleDateFormat) r12
            java.lang.Object r13 = r6.L$4
            java.text.SimpleDateFormat r13 = (java.text.SimpleDateFormat) r13
            java.lang.Object r5 = r6.L$3
            kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
            r18 = r0
            java.lang.Object r0 = r6.L$2
            r19 = r0
            kotlin.jvm.internal.Ref$DoubleRef r19 = (kotlin.jvm.internal.Ref.DoubleRef) r19
            java.lang.Object r0 = r6.L$1
            r20 = r0
            java.util.Calendar r20 = (java.util.Calendar) r20
            java.lang.Object r0 = r6.L$0
            r21 = r0
            java.lang.String r21 = (java.lang.String) r21
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L96
            r34 = r74
            r56 = r1
            r36 = r2
            r54 = r3
            r3 = r7
            r33 = r12
            r12 = r14
            r55 = r15
            r14 = r18
            r15 = r19
            r1 = 0
            r2 = r76
            goto L80c
        L96:
            r0 = move-exception
            r34 = r74
            r1 = r76
            goto La6f
        L9d:
            int r0 = r6.I$3
            int r5 = r6.I$2
            r25 = r0
            int r0 = r6.I$1
            r26 = r0
            int r0 = r6.I$0
            r27 = r0
            java.lang.Object r0 = r6.L$7
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            r28 = r0
            java.lang.Object r0 = r6.L$6
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            r29 = r0
            java.lang.Object r0 = r6.L$5
            java.text.SimpleDateFormat r0 = (java.text.SimpleDateFormat) r0
            r30 = r0
            java.lang.Object r0 = r6.L$4
            java.text.SimpleDateFormat r0 = (java.text.SimpleDateFormat) r0
            r31 = r0
            java.lang.Object r0 = r6.L$3
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            r32 = r0
            java.lang.Object r0 = r6.L$2
            kotlin.jvm.internal.Ref$DoubleRef r0 = (kotlin.jvm.internal.Ref.DoubleRef) r0
            r33 = r0
            java.lang.Object r0 = r6.L$1
            java.util.Calendar r0 = (java.util.Calendar) r0
            r34 = r0
            java.lang.Object r0 = r6.L$0
            r35 = r0
            java.lang.String r35 = (java.lang.String) r35
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L112
            r56 = r1
            r36 = r2
            r54 = r3
            r57 = r4
            r3 = r6
            r37 = r9
            r38 = r10
            r40 = r12
            r39 = r13
            r58 = r14
            r55 = r15
            r15 = r29
            r1 = r30
            r4 = r31
            r14 = r32
            r2 = r33
            r6 = r35
            r9 = r8
            r8 = r25
            r30 = r28
            r28 = r34
            r34 = r74
            r25 = r7
            r7 = r27
            r27 = r5
            r0 = r76
            goto L48c
        L112:
            r0 = move-exception
            r34 = r74
            r27 = r76
            r51 = r6
            r6 = r35
            goto Lab7
        L11d:
            r0 = 0
            int r5 = r6.I$3
            r25 = r5
            int r5 = r6.I$2
            r26 = r5
            int r5 = r6.I$1
            r27 = r5
            int r5 = r6.I$0
            r28 = r0
            java.lang.Object r0 = r6.L$8
            com.phisher98.donation.DonationManager r0 = (com.phisher98.donation.DonationManager) r0
            r29 = r0
            java.lang.Object r0 = r6.L$7
            r30 = r0
            com.lagradost.nicehttp.NiceResponse r30 = (com.lagradost.nicehttp.NiceResponse) r30
            java.lang.Object r0 = r6.L$6
            r31 = r0
            kotlin.jvm.internal.Ref$IntRef r31 = (kotlin.jvm.internal.Ref.IntRef) r31
            java.lang.Object r0 = r6.L$5
            r32 = r0
            java.text.SimpleDateFormat r32 = (java.text.SimpleDateFormat) r32
            java.lang.Object r0 = r6.L$4
            r33 = r0
            java.text.SimpleDateFormat r33 = (java.text.SimpleDateFormat) r33
            java.lang.Object r0 = r6.L$3
            r34 = r0
            kotlin.jvm.internal.Ref$IntRef r34 = (kotlin.jvm.internal.Ref.IntRef) r34
            java.lang.Object r0 = r6.L$2
            r35 = r0
            kotlin.jvm.internal.Ref$DoubleRef r35 = (kotlin.jvm.internal.Ref.DoubleRef) r35
            java.lang.Object r0 = r6.L$1
            r36 = r0
            java.util.Calendar r36 = (java.util.Calendar) r36
            java.lang.Object r0 = r6.L$0
            r37 = r0
            java.lang.String r37 = (java.lang.String) r37
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L18c
            r56 = r1
            r54 = r3
            r57 = r4
            r58 = r14
            r55 = r15
            r0 = r29
            r15 = r31
            r3 = r32
            r14 = r34
            r34 = r74
            r1 = r76
            r32 = r25
            r31 = r28
            r28 = r36
            r36 = r2
            r25 = r7
            r2 = r8
            r8 = r26
            goto L32b
        L18c:
            r0 = move-exception
            r56 = r1
            r54 = r3
            r57 = r4
            r51 = r6
            r58 = r14
            r55 = r15
            r3 = r32
            r14 = r34
            r28 = r36
            r6 = r37
            r34 = r74
            r1 = r76
            r36 = r2
            r2 = r8
            r32 = r25
            r8 = r26
            goto L406
        L1ae:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r19)     // Catch: java.lang.Throwable -> Laac
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)     // Catch: java.lang.Throwable -> Laac
            r5 = 1
            int r25 = r0.get(r5)     // Catch: java.lang.Throwable -> Laac
            r5 = 2
            int r26 = r0.get(r5)     // Catch: java.lang.Throwable -> Laac
            kotlin.jvm.internal.Ref$DoubleRef r5 = new kotlin.jvm.internal.Ref$DoubleRef     // Catch: java.lang.Throwable -> Laac
            r5.<init>()     // Catch: java.lang.Throwable -> Laac
            kotlin.jvm.internal.Ref$IntRef r27 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Throwable -> Laac
            r27.<init>()     // Catch: java.lang.Throwable -> Laac
            r28 = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> Laac
            r29 = r5
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            r30 = r6
            java.util.Locale r6 = java.util.Locale.US     // Catch: java.lang.Throwable -> Laa2
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> Laa2
            r5 = r0
            r6 = 0
            r31 = r0
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r19)     // Catch: java.lang.Throwable -> Laa2
            r5.setTimeZone(r0)     // Catch: java.lang.Throwable -> Laa2
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> Laa2
            java.lang.String r5 = "yyyy-MM-dd'T'HH:mm:ss"
            java.util.Locale r6 = java.util.Locale.US     // Catch: java.lang.Throwable -> Laa2
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> Laa2
            r5 = r0
            r6 = 0
            r32 = r0
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r19)     // Catch: java.lang.Throwable -> Laa2
            r5.setTimeZone(r0)     // Catch: java.lang.Throwable -> Laa2
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Throwable -> Laa2
            r0.<init>()     // Catch: java.lang.Throwable -> Laa2
            r5 = 1
            r0.element = r5     // Catch: java.lang.Throwable -> Laa2
            r5 = 1
            r34 = r74
            r6 = r76
            r33 = r32
            r32 = r31
            r31 = r27
            r27 = r26
            r26 = r25
            r25 = r8
            r8 = r7
            r7 = r5
            r5 = r75
        L21d:
            if (r7 == 0) goto L72e
            r75 = r5
            int r5 = r0.element     // Catch: java.lang.Throwable -> L723
            r35 = r0
            r0 = 10
            if (r5 > r0) goto L710
            r0 = 0
            r5 = 1
            r36 = r6
            r6 = r75
            r75 = r36
            r36 = r27
            r27 = r7
            r7 = r26
            r26 = r25
            r25 = r8
            r8 = r36
            r56 = r1
            r36 = r2
            r54 = r3
            r57 = r4
            r58 = r14
            r55 = r15
            r2 = r29
            r3 = r30
            r14 = r31
            r4 = r32
            r1 = r33
            r15 = r35
            r30 = r0
        L257:
            r29 = r8
            r8 = 3
            if (r5 >= r8) goto L4cf
        L25d:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L3e9
            r0 = r34
            com.phisher98.donation.DonationManager r0 = (com.phisher98.donation.DonationManager) r0     // Catch: java.lang.Throwable -> L3e9
            r8 = 0
            com.lagradost.nicehttp.Requests r37 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> L3e9
            r76 = r0
            int r0 = r15.element     // Catch: java.lang.Throwable -> L3e9
            r31 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e9
            r8.<init>()     // Catch: java.lang.Throwable -> L3e9
            r32 = r5
            java.lang.String r5 = "https://developers.buymeacoffee.com/api/v1/supporters?page="
            java.lang.StringBuilder r5 = r8.append(r5)     // Catch: java.lang.Throwable -> L3cd
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch: java.lang.Throwable -> L3cd
            java.lang.String r38 = r0.toString()     // Catch: java.lang.Throwable -> L3cd
            r5 = 4
            kotlin.Pair[] r0 = new kotlin.Pair[r5]     // Catch: java.lang.Throwable -> L3cd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3cd
            r5.<init>()     // Catch: java.lang.Throwable -> L3cd
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L3cd
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L3cd
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L3cd
            kotlin.Pair r5 = kotlin.TuplesKt.to(r12, r5)     // Catch: java.lang.Throwable -> L3cd
            r0[r23] = r5     // Catch: java.lang.Throwable -> L3cd
            kotlin.Pair r5 = kotlin.TuplesKt.to(r10, r13)     // Catch: java.lang.Throwable -> L3cd
            r24 = 1
            r0[r24] = r5     // Catch: java.lang.Throwable -> L3cd
            kotlin.Pair r5 = kotlin.TuplesKt.to(r9, r13)     // Catch: java.lang.Throwable -> L3cd
            r21 = 2
            r0[r21] = r5     // Catch: java.lang.Throwable -> L3cd
            java.lang.String r5 = "User-Agent"
            java.lang.String r8 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r8)     // Catch: java.lang.Throwable -> L3cd
            r20 = 3
            r0[r20] = r5     // Catch: java.lang.Throwable -> L3cd
            java.util.Map r39 = kotlin.collections.MapsKt.mapOf(r0)     // Catch: java.lang.Throwable -> L3cd
            r3.L$0 = r6     // Catch: java.lang.Throwable -> L3cd
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)     // Catch: java.lang.Throwable -> L3cd
            r3.L$1 = r0     // Catch: java.lang.Throwable -> L3cd
            r3.L$2 = r2     // Catch: java.lang.Throwable -> L3cd
            r3.L$3 = r14     // Catch: java.lang.Throwable -> L3cd
            r3.L$4 = r4     // Catch: java.lang.Throwable -> L3cd
            r3.L$5 = r1     // Catch: java.lang.Throwable -> L3cd
            r3.L$6 = r15     // Catch: java.lang.Throwable -> L3cd
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r30)     // Catch: java.lang.Throwable -> L3cd
            r3.L$7 = r0     // Catch: java.lang.Throwable -> L3cd
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r76)     // Catch: java.lang.Throwable -> L3cd
            r3.L$8 = r0     // Catch: java.lang.Throwable -> L3cd
            r3.I$0 = r7     // Catch: java.lang.Throwable -> L3cd
            r5 = r29
            r3.I$1 = r5     // Catch: java.lang.Throwable -> L3b3
            r8 = r27
            r3.I$2 = r8     // Catch: java.lang.Throwable -> L39a
            r27 = r1
            r1 = r32
            r3.I$3 = r1     // Catch: java.lang.Throwable -> L381
            r32 = r1
            r1 = 1
            r3.label = r1     // Catch: java.lang.Throwable -> L36a
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 10
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 3836(0xefc, float:5.375E-42)
            r53 = 0
            r51 = r3
            java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r48, r49, r50, r51, r52, r53)     // Catch: java.lang.Throwable -> L355
            r1 = r26
            if (r0 != r1) goto L318
            return r1
        L318:
            r35 = r2
            r33 = r4
            r37 = r6
            r3 = r27
            r6 = r51
            r2 = r1
            r27 = r5
            r5 = r7
            r1 = r75
            r7 = r0
            r0 = r76
        L32b:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7     // Catch: java.lang.Throwable -> L34a
            java.lang.Object r0 = kotlin.Result.constructor-impl(r7)     // Catch: java.lang.Throwable -> L34a
            r76 = r1
            r1 = r6
            r6 = r37
            r26 = r0
            r7 = r3
            r0 = r8
            r75 = r28
            r8 = r32
            r4 = r33
            r3 = r35
            r37 = r9
            r9 = r2
            r2 = r27
            goto L429
        L34a:
            r0 = move-exception
            r51 = r6
            r31 = r15
            r7 = r25
            r6 = r37
            goto L406
        L355:
            r0 = move-exception
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
            goto L406
        L36a:
            r0 = move-exception
            r51 = r3
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
            goto L406
        L381:
            r0 = move-exception
            r32 = r1
            r51 = r3
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
            goto L406
        L39a:
            r0 = move-exception
            r27 = r1
            r51 = r3
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
            goto L406
        L3b3:
            r0 = move-exception
            r51 = r3
            r8 = r27
            r27 = r1
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
            goto L406
        L3cd:
            r0 = move-exception
            r51 = r3
            r8 = r27
            r5 = r29
            r27 = r1
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
            goto L406
        L3e9:
            r0 = move-exception
            r51 = r3
            r32 = r5
            r8 = r27
            r5 = r29
            r27 = r1
            r1 = r26
            r35 = r2
            r33 = r4
            r31 = r15
            r3 = r27
            r2 = r1
            r27 = r5
            r5 = r7
            r7 = r25
            r1 = r75
        L406:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L4ca
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> L4ca
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L4ca
            r76 = r1
            r25 = r7
            r15 = r31
            r1 = r51
            r26 = r0
            r0 = r8
            r37 = r9
            r75 = r28
            r8 = r32
            r4 = r33
            r9 = r2
            r7 = r3
            r2 = r27
            r3 = r35
        L429:
            boolean r27 = kotlin.Result.isFailure-impl(r26)     // Catch: java.lang.Throwable -> L4c1
            if (r27 == 0) goto L431
            r26 = 0
        L431:
            com.lagradost.nicehttp.NiceResponse r26 = (com.lagradost.nicehttp.NiceResponse) r26     // Catch: java.lang.Throwable -> L4c1
            r27 = r26
            if (r27 == 0) goto L4a6
            r38 = r10
            int r10 = r27.getCode()     // Catch: java.lang.Throwable -> L4c1
            r39 = r13
            r13 = 429(0x1ad, float:6.01E-43)
            if (r10 != r13) goto L4a1
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.Companion     // Catch: java.lang.Throwable -> L4c1
            kotlin.time.DurationUnit r10 = kotlin.time.DurationUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L4c1
            r40 = r12
            r12 = 2000(0x7d0, double:9.88E-321)
            long r12 = kotlin.time.DurationKt.toDuration(r12, r10)     // Catch: java.lang.Throwable -> L4c1
            r1.L$0 = r6     // Catch: java.lang.Throwable -> L4c1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r75)     // Catch: java.lang.Throwable -> L4c1
            r1.L$1 = r10     // Catch: java.lang.Throwable -> L4c1
            r1.L$2 = r3     // Catch: java.lang.Throwable -> L4c1
            r1.L$3 = r14     // Catch: java.lang.Throwable -> L4c1
            r1.L$4 = r4     // Catch: java.lang.Throwable -> L4c1
            r1.L$5 = r7     // Catch: java.lang.Throwable -> L4c1
            r1.L$6 = r15     // Catch: java.lang.Throwable -> L4c1
            r10 = r27
            r1.L$7 = r10     // Catch: java.lang.Throwable -> L4c1
            r26 = r3
            r3 = 0
            r1.L$8 = r3     // Catch: java.lang.Throwable -> L4c1
            r1.I$0 = r5     // Catch: java.lang.Throwable -> L4c1
            r1.I$1 = r2     // Catch: java.lang.Throwable -> L4c1
            r1.I$2 = r0     // Catch: java.lang.Throwable -> L4c1
            r1.I$3 = r8     // Catch: java.lang.Throwable -> L4c1
            r3 = 2
            r1.label = r3     // Catch: java.lang.Throwable -> L4c1
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay-VtjQ1oo(r12, r1)     // Catch: java.lang.Throwable -> L4c1
            if (r3 != r9) goto L47c
            return r9
        L47c:
            r3 = r26
            r26 = r2
            r2 = r3
            r28 = r75
            r27 = r0
            r3 = r1
            r1 = r7
            r30 = r10
            r7 = r5
            r0 = r76
        L48c:
            r24 = 1
            int r5 = r8 + 1
            r75 = r0
            r8 = r26
            r10 = r38
            r13 = r39
            r12 = r40
            r26 = r9
            r9 = r37
            goto L257
        L4a1:
            r26 = r3
            r40 = r12
            goto L4ae
        L4a6:
            r26 = r3
            r38 = r10
            r40 = r12
            r39 = r13
        L4ae:
            r10 = r27
            r28 = r75
            r8 = r0
            r51 = r1
            r1 = r9
            r30 = r10
            r3 = r26
            r9 = r7
            r7 = r5
            r5 = r6
            r6 = r76
            r0 = r15
            goto L4eb
        L4c1:
            r0 = move-exception
            r27 = r76
            r51 = r1
            r7 = r25
            goto Lab7
        L4ca:
            r0 = move-exception
            r27 = r1
            goto Lab7
        L4cf:
            r51 = r3
            r32 = r5
            r37 = r9
            r38 = r10
            r40 = r12
            r39 = r13
            r8 = r27
            r5 = r29
            r27 = r1
            r1 = r26
            r3 = r2
            r2 = r5
            r5 = r6
            r9 = r27
            r6 = r75
            r0 = r15
        L4eb:
            if (r30 == 0) goto L6dc
            int r10 = r30.getCode()     // Catch: java.lang.Throwable -> L6d1
            r12 = 200(0xc8, float:2.8E-43)
            if (r12 > r10) goto L4fb
            r12 = 300(0x12c, float:4.2E-43)
            if (r10 >= r12) goto L4fb
            r10 = 1
            goto L4fc
        L4fb:
            r10 = 0
        L4fc:
            if (r10 != 0) goto L50e
            r75 = r1
            r43 = r4
            r76 = r5
            r27 = r6
            r29 = r8
            r41 = r9
            r12 = r58
            goto L6ea
        L50e:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6d1
            java.lang.String r12 = r30.getText()     // Catch: java.lang.Throwable -> L6d1
            r10.<init>(r12)     // Catch: java.lang.Throwable -> L6d1
            r12 = r58
            org.json.JSONArray r13 = r10.optJSONArray(r12)     // Catch: java.lang.Throwable -> L6d1
            if (r13 != 0) goto L53d
            int r13 = r0.element     // Catch: java.lang.Throwable -> L535
            r15 = 1
            if (r13 != r15) goto L527
            r22 = 0
            return r22
        L527:
            r75 = r1
            r43 = r4
            r76 = r5
            r27 = r6
            r29 = r8
            r41 = r9
            goto L6f2
        L535:
            r0 = move-exception
            r27 = r6
            r7 = r25
            r6 = r5
            goto Lab7
        L53d:
            int r15 = r13.length()     // Catch: java.lang.Throwable -> L6d1
            if (r15 == 0) goto L6c2
            r15 = 0
            r75 = r1
            int r1 = r13.length()     // Catch: java.lang.Throwable -> L6d1
        L54a:
            if (r15 >= r1) goto L672
            org.json.JSONObject r26 = r13.getJSONObject(r15)     // Catch: java.lang.Throwable -> L6d1
            r76 = r26
            r26 = r1
            r27 = r6
            r6 = 0
            r1 = r76
            r76 = r5
            r5 = r57
            boolean r23 = r1.optBoolean(r5, r6)     // Catch: java.lang.Throwable -> L709
            if (r23 != 0) goto L57b
            r29 = r8
            int r8 = r1.optInt(r5, r6)     // Catch: java.lang.Throwable -> L709
            r6 = 1
            if (r8 == r6) goto L57d
            java.lang.String r6 = r1.optString(r5)     // Catch: java.lang.Throwable -> L709
            java.lang.String r8 = "1"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r8)     // Catch: java.lang.Throwable -> L709
            if (r6 == 0) goto L579
            goto L57d
        L579:
            r6 = 0
            goto L57e
        L57b:
            r29 = r8
        L57d:
            r6 = 1
        L57e:
            java.lang.String r8 = "refunded_at"
            r57 = r5
            r5 = r56
            java.lang.String r8 = r1.optString(r8, r5)     // Catch: java.lang.Throwable -> L709
            if (r6 != 0) goto L651
            r31 = r8
            java.lang.CharSequence r31 = (java.lang.CharSequence) r31     // Catch: java.lang.Throwable -> L709
            boolean r31 = kotlin.text.StringsKt.isBlank(r31)     // Catch: java.lang.Throwable -> L709
            if (r31 != 0) goto L5ad
            r31 = r6
            r6 = r55
            boolean r32 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r6)     // Catch: java.lang.Throwable -> L709
            if (r32 != 0) goto L5b1
            r43 = r4
            r56 = r5
            r55 = r6
            r32 = r8
            r41 = r9
            r33 = r13
            goto L65d
        L5ad:
            r31 = r6
            r6 = r55
        L5b1:
            r32 = r8
            java.lang.String r8 = "support_created_on"
            r33 = r13
            java.lang.String r13 = "order_created_on"
            java.lang.String r13 = r1.optString(r13, r5)     // Catch: java.lang.Throwable -> L709
            java.lang.String r8 = r1.optString(r8, r13)     // Catch: java.lang.Throwable -> L709
            r13 = r8
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch: java.lang.Throwable -> L709
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)     // Catch: java.lang.Throwable -> L709
            if (r13 != 0) goto L646
            java.util.Date r13 = fetchBuyMeACoffeeMonthly$parseDate(r4, r9, r8)     // Catch: java.lang.Throwable -> L709
            if (r13 == 0) goto L63b
            java.util.TimeZone r35 = java.util.TimeZone.getTimeZone(r19)     // Catch: java.lang.Throwable -> L709
            java.util.Calendar r35 = java.util.Calendar.getInstance(r35)     // Catch: java.lang.Throwable -> L709
            r41 = r35
            r42 = 0
            r43 = r4
            r4 = r41
            r4.setTime(r13)     // Catch: java.lang.Throwable -> L709
            r4 = r35
            r35 = r8
            r41 = r9
            r8 = 1
            int r9 = r4.get(r8)     // Catch: java.lang.Throwable -> L709
            if (r9 != r7) goto L621
            r8 = 2
            int r9 = r4.get(r8)     // Catch: java.lang.Throwable -> L709
            if (r9 != r2) goto L621
            java.lang.String r8 = "support_coffees"
            r9 = 1
            int r8 = r1.optInt(r8, r9)     // Catch: java.lang.Throwable -> L709
            java.lang.String r9 = "support_coffee_price"
            r56 = r5
            r55 = r6
            r5 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r5 = r1.optDouble(r9, r5)     // Catch: java.lang.Throwable -> L709
            r44 = r5
            double r5 = r3.element     // Catch: java.lang.Throwable -> L709
            r46 = r5
            double r5 = (double) r8     // Catch: java.lang.Throwable -> L709
            double r5 = r5 * r44
            double r5 = r46 + r5
            r3.element = r5     // Catch: java.lang.Throwable -> L709
            int r5 = r14.element     // Catch: java.lang.Throwable -> L709
            r24 = 1
            int r5 = r5 + 1
            r14.element = r5     // Catch: java.lang.Throwable -> L709
            goto L65e
        L621:
            r56 = r5
            r55 = r6
            r5 = 1
            int r6 = r4.get(r5)     // Catch: java.lang.Throwable -> L709
            if (r6 < r7) goto L639
            int r6 = r4.get(r5)     // Catch: java.lang.Throwable -> L709
            if (r6 != r7) goto L65e
            r5 = 2
            int r6 = r4.get(r5)     // Catch: java.lang.Throwable -> L709
            if (r6 >= r2) goto L65e
        L639:
            r8 = 0
            goto L67e
        L63b:
            r43 = r4
            r56 = r5
            r55 = r6
            r35 = r8
            r41 = r9
            goto L65e
        L646:
            r43 = r4
            r56 = r5
            r55 = r6
            r35 = r8
            r41 = r9
            goto L65e
        L651:
            r43 = r4
            r56 = r5
            r31 = r6
            r32 = r8
            r41 = r9
            r33 = r13
        L65d:
        L65e:
            int r15 = r15 + 1
            r5 = r76
            r1 = r26
            r6 = r27
            r8 = r29
            r13 = r33
            r9 = r41
            r4 = r43
            r23 = 0
            goto L54a
        L672:
            r43 = r4
            r76 = r5
            r27 = r6
            r29 = r8
            r41 = r9
            r33 = r13
        L67e:
            java.lang.String r1 = "last_page"
            r5 = 1
            int r1 = r10.optInt(r1, r5)     // Catch: java.lang.Throwable -> L709
            int r4 = r0.element     // Catch: java.lang.Throwable -> L709
            if (r4 < r1) goto L68b
            r4 = 0
            goto L68c
        L68b:
            r4 = r8
        L68c:
            int r5 = r0.element     // Catch: java.lang.Throwable -> L709
            r24 = 1
            int r5 = r5 + 1
            r0.element = r5     // Catch: java.lang.Throwable -> L709
            r5 = r76
            r29 = r3
            r26 = r7
            r31 = r14
            r8 = r25
            r6 = r27
            r9 = r37
            r10 = r38
            r13 = r39
            r33 = r41
            r32 = r43
            r30 = r51
            r3 = r54
            r15 = r55
            r1 = r56
            r23 = 0
            r25 = r75
            r27 = r2
            r7 = r4
            r14 = r12
            r2 = r36
            r12 = r40
            r4 = r57
            goto L21d
        L6c2:
            r75 = r1
            r43 = r4
            r76 = r5
            r27 = r6
            r29 = r8
            r41 = r9
            r33 = r13
            goto L6f2
        L6d1:
            r0 = move-exception
            r76 = r5
            r27 = r6
            r6 = r76
            r7 = r25
            goto Lab7
        L6dc:
            r75 = r1
            r43 = r4
            r76 = r5
            r27 = r6
            r29 = r8
            r41 = r9
            r12 = r58
        L6ea:
            int r1 = r0.element     // Catch: java.lang.Throwable -> L709
            r5 = 1
            if (r1 != r5) goto L6f2
            r22 = 0
            return r22
        L6f2:
            r35 = r0
            r8 = r2
            r9 = r7
            r5 = r14
            r7 = r25
            r1 = r27
            r4 = r29
            r33 = r41
            r13 = r43
            r6 = r51
            r0 = r75
            r2 = r76
            goto L756
        L709:
            r0 = move-exception
            r6 = r76
            r7 = r25
            goto Lab7
        L710:
            r56 = r1
            r36 = r2
            r54 = r3
            r1 = r6
            r37 = r9
            r38 = r10
            r40 = r12
            r39 = r13
            r12 = r14
            r55 = r15
            goto L744
        L723:
            r0 = move-exception
            r1 = r6
            r6 = r75
            r27 = r1
            r7 = r8
            r51 = r30
            goto Lab7
        L72e:
            r35 = r0
            r56 = r1
            r36 = r2
            r54 = r3
            r75 = r5
            r1 = r6
            r37 = r9
            r38 = r10
            r40 = r12
            r39 = r13
            r12 = r14
            r55 = r15
        L744:
            r2 = r75
            r4 = r7
            r7 = r8
            r0 = r25
            r9 = r26
            r8 = r27
            r3 = r29
            r6 = r30
            r5 = r31
            r13 = r32
        L756:
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> La60
            r10 = r34
            com.phisher98.donation.DonationManager r10 = (com.phisher98.donation.DonationManager) r10     // Catch: java.lang.Throwable -> La60
            r14 = 0
            com.lagradost.nicehttp.Requests r57 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> La60
            java.lang.String r58 = "https://developers.buymeacoffee.com/api/v1/subscriptions?status=active"
            r15 = 4
            kotlin.Pair[] r15 = new kotlin.Pair[r15]     // Catch: java.lang.Throwable -> La60
            r75 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La50
            r1.<init>()     // Catch: java.lang.Throwable -> La50
            java.lang.StringBuilder r1 = r1.append(r11)     // Catch: java.lang.Throwable -> La50
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> La50
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La50
            r11 = r40
            kotlin.Pair r1 = kotlin.TuplesKt.to(r11, r1)     // Catch: java.lang.Throwable -> La50
            r23 = 0
            r15[r23] = r1     // Catch: java.lang.Throwable -> La50
            r1 = r38
            r11 = r39
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r11)     // Catch: java.lang.Throwable -> La50
            r24 = 1
            r15[r24] = r1     // Catch: java.lang.Throwable -> La50
            r1 = r37
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r11)     // Catch: java.lang.Throwable -> La50
            r21 = 2
            r15[r21] = r1     // Catch: java.lang.Throwable -> La50
            java.lang.String r1 = "User-Agent"
            java.lang.String r11 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r11)     // Catch: java.lang.Throwable -> La50
            r20 = 3
            r15[r20] = r1     // Catch: java.lang.Throwable -> La50
            java.util.Map r59 = kotlin.collections.MapsKt.mapOf(r15)     // Catch: java.lang.Throwable -> La50
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch: java.lang.Throwable -> La50
            r6.L$0 = r1     // Catch: java.lang.Throwable -> La50
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)     // Catch: java.lang.Throwable -> La50
            r6.L$1 = r1     // Catch: java.lang.Throwable -> La50
            r6.L$2 = r3     // Catch: java.lang.Throwable -> La50
            r6.L$3 = r5     // Catch: java.lang.Throwable -> La50
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)     // Catch: java.lang.Throwable -> La50
            r6.L$4 = r1     // Catch: java.lang.Throwable -> La50
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r33)     // Catch: java.lang.Throwable -> La50
            r6.L$5 = r1     // Catch: java.lang.Throwable -> La50
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r35)     // Catch: java.lang.Throwable -> La50
            r6.L$6 = r1     // Catch: java.lang.Throwable -> La50
            r6.L$7 = r10     // Catch: java.lang.Throwable -> La50
            r1 = 0
            r6.L$8 = r1     // Catch: java.lang.Throwable -> La50
            r6.I$0 = r9     // Catch: java.lang.Throwable -> La50
            r6.I$1 = r8     // Catch: java.lang.Throwable -> La50
            r6.I$2 = r4     // Catch: java.lang.Throwable -> La50
            r11 = 3
            r6.label = r11     // Catch: java.lang.Throwable -> La50
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = 10
            r68 = 0
            r69 = 0
            r70 = 0
            r72 = 3836(0xefc, float:5.375E-42)
            r73 = 0
            r71 = r6
            java.lang.Object r6 = com.lagradost.nicehttp.Requests.get$default(r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r68, r69, r70, r71, r72, r73)     // Catch: java.lang.Throwable -> La40
            if (r6 != r0) goto L7ff
            return r0
        L7ff:
            r21 = r2
            r15 = r3
            r3 = r7
            r20 = r28
            r11 = r35
            r2 = r75
            r7 = r6
            r6 = r71
        L80c:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7     // Catch: java.lang.Throwable -> La2e
            int r0 = r7.getCode()     // Catch: java.lang.Throwable -> La2e
            r1 = 200(0xc8, float:2.8E-43)
            if (r1 > r0) goto L81c
            r1 = 300(0x12c, float:4.2E-43)
            if (r0 >= r1) goto L81c
            r0 = 1
            goto L81d
        L81c:
            r0 = 0
        L81d:
            if (r0 == 0) goto La06
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La2e
            java.lang.String r1 = r7.getText()     // Catch: java.lang.Throwable -> La2e
            r0.<init>(r1)     // Catch: java.lang.Throwable -> La2e
            r1 = r0
            org.json.JSONArray r0 = r1.optJSONArray(r12)     // Catch: java.lang.Throwable -> La2e
            r12 = r0
            if (r12 == 0) goto L9f9
            r0 = 0
            r75 = r1
            int r1 = r12.length()     // Catch: java.lang.Throwable -> La2e
            r76 = r2
            r2 = r0
        L83a:
            if (r2 >= r1) goto L9ee
            org.json.JSONObject r0 = r12.getJSONObject(r2)     // Catch: java.lang.Throwable -> L9dd
            r16 = r0
            r17 = r1
            r18 = r3
            r1 = r16
            r3 = 0
            r16 = r2
            r2 = r54
            int r0 = r1.optInt(r2, r3)     // Catch: java.lang.Throwable -> L9ce
            r3 = 1
            if (r0 == r3) goto L869
            r3 = 0
            boolean r0 = r1.optBoolean(r2, r3)     // Catch: java.lang.Throwable -> L85e
            if (r0 == 0) goto L85c
            goto L869
        L85c:
            r0 = 0
            goto L86a
        L85e:
            r0 = move-exception
            r1 = r76
            r19 = r15
            r7 = r18
            r12 = r33
            goto La6f
        L869:
            r0 = 1
        L86a:
            r3 = r0
            java.lang.String r0 = "subscription_cancelled_on"
            r54 = r2
            r2 = r56
            java.lang.String r0 = r1.optString(r0, r2)     // Catch: java.lang.Throwable -> L9ce
            r19 = r0
            r25 = r3
            r23 = r4
            r3 = r36
            r4 = 0
            int r0 = r1.optInt(r3, r4)     // Catch: java.lang.Throwable -> L9bf
            r4 = 1
            if (r0 == r4) goto L89c
            r4 = 0
            boolean r0 = r1.optBoolean(r3, r4)     // Catch: java.lang.Throwable -> L88f
            if (r0 == 0) goto L88d
            goto L89d
        L88d:
            r0 = 0
            goto L89e
        L88f:
            r0 = move-exception
            r1 = r76
            r19 = r15
            r7 = r18
            r4 = r23
            r12 = r33
            goto La6f
        L89c:
            r4 = 0
        L89d:
            r0 = 1
        L89e:
            r26 = r0
            java.lang.String r0 = "stripe_status"
            java.lang.String r0 = r1.optString(r0, r2)     // Catch: java.lang.Throwable -> L9bf
            r27 = r0
            r0 = 0
            r28 = 1
            java.lang.String r0 = "meta"
            java.lang.String r0 = r1.optString(r0, r2)     // Catch: java.lang.Throwable -> L9bf
            r29 = r0
            r0 = r29
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Throwable -> L9bf
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)     // Catch: java.lang.Throwable -> L9bf
            if (r0 != 0) goto L90c
            r56 = r2
            r4 = r29
            r2 = r55
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)     // Catch: java.lang.Throwable -> L88f
            if (r0 != 0) goto L907
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L8f8
            r0 = r10
            r29 = 0
            r31 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L8f8
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L8f8
            r36 = r3
            java.lang.String r3 = "payment_completed"
            boolean r3 = r0.has(r3)     // Catch: java.lang.Throwable -> L8f6
            if (r3 == 0) goto L8eb
            java.lang.String r3 = "payment_completed"
            r32 = r4
            r4 = 1
            boolean r3 = r0.optBoolean(r3, r4)     // Catch: java.lang.Throwable -> L8f4
            r28 = r3
            goto L8ed
        L8eb:
            r32 = r4
        L8ed:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L8f4
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L8f4
            goto L914
        L8f4:
            r0 = move-exception
            goto L8fd
        L8f6:
            r0 = move-exception
            goto L8fb
        L8f8:
            r0 = move-exception
            r36 = r3
        L8fb:
            r32 = r4
        L8fd:
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L88f
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> L88f
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L88f
            goto L914
        L907:
            r36 = r3
            r32 = r4
            goto L914
        L90c:
            r56 = r2
            r36 = r3
            r32 = r29
            r2 = r55
        L914:
            if (r25 != 0) goto L9a4
            r0 = r19
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Throwable -> L9bf
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)     // Catch: java.lang.Throwable -> L9bf
            if (r0 != 0) goto L939
            r3 = r19
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)     // Catch: java.lang.Throwable -> L88f
            if (r0 == 0) goto L929
            goto L93b
        L929:
            r31 = r1
            r55 = r2
            r19 = r3
            r29 = r7
            r4 = r27
            r24 = 1
            r27 = r6
            goto L9b0
        L939:
            r3 = r19
        L93b:
            if (r26 != 0) goto L995
            java.lang.String r0 = "active"
            r4 = r27
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)     // Catch: java.lang.Throwable -> L9bf
            if (r0 == 0) goto L988
            if (r28 != 0) goto L956
            r31 = r1
            r55 = r2
            r19 = r3
            r27 = r6
            r29 = r7
            r24 = 1
            goto L9b0
        L956:
            java.lang.String r0 = "subscription_coffee_num"
            r55 = r2
            r2 = 1
            int r0 = r1.optInt(r0, r2)     // Catch: java.lang.Throwable -> L9bf
            java.lang.String r2 = "subscription_coffee_price"
            r19 = r3
            java.lang.String r3 = "psp_subscription_price"
            r27 = r6
            r29 = r7
            r6 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r6 = r1.optDouble(r3, r6)     // Catch: java.lang.Throwable -> La20
            double r2 = r1.optDouble(r2, r6)     // Catch: java.lang.Throwable -> La20
            double r6 = r15.element     // Catch: java.lang.Throwable -> La20
            r31 = r1
            r37 = r2
            double r1 = (double) r0     // Catch: java.lang.Throwable -> La20
            double r1 = r1 * r37
            double r6 = r6 + r1
            r15.element = r6     // Catch: java.lang.Throwable -> La20
            int r1 = r5.element     // Catch: java.lang.Throwable -> La20
            r24 = 1
            int r1 = r1 + 1
            r5.element = r1     // Catch: java.lang.Throwable -> La20
            goto L9b1
        L988:
            r31 = r1
            r55 = r2
            r19 = r3
            r27 = r6
            r29 = r7
            r24 = 1
            goto L9b0
        L995:
            r31 = r1
            r55 = r2
            r19 = r3
            r29 = r7
            r4 = r27
            r24 = 1
            r27 = r6
            goto L9b0
        L9a4:
            r31 = r1
            r55 = r2
            r29 = r7
            r4 = r27
            r24 = 1
            r27 = r6
        L9b0:
        L9b1:
            int r2 = r16 + 1
            r1 = r17
            r3 = r18
            r4 = r23
            r6 = r27
            r7 = r29
            goto L83a
        L9bf:
            r0 = move-exception
            r27 = r6
            r1 = r76
            r19 = r15
            r7 = r18
            r4 = r23
            r12 = r33
            goto La6f
        L9ce:
            r0 = move-exception
            r23 = r4
            r27 = r6
            r1 = r76
            r19 = r15
            r7 = r18
            r12 = r33
            goto La6f
        L9dd:
            r0 = move-exception
            r18 = r3
            r23 = r4
            r27 = r6
            r1 = r76
            r19 = r15
            r7 = r18
            r12 = r33
            goto La6f
        L9ee:
            r16 = r2
            r18 = r3
            r23 = r4
            r27 = r6
            r29 = r7
            goto La10
        L9f9:
            r75 = r1
            r76 = r2
            r18 = r3
            r23 = r4
            r27 = r6
            r29 = r7
            goto La10
        La06:
            r76 = r2
            r18 = r3
            r23 = r4
            r27 = r6
            r29 = r7
        La10:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La20
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> La20
            r1 = r76
            r7 = r18
            r4 = r23
            r6 = r27
            goto La7c
        La20:
            r0 = move-exception
            r1 = r76
            r19 = r15
            r7 = r18
            r4 = r23
            r6 = r27
            r12 = r33
            goto La6f
        La2e:
            r0 = move-exception
            r76 = r2
            r18 = r3
            r23 = r4
            r27 = r6
            r1 = r76
            r19 = r15
            r7 = r18
            r12 = r33
            goto La6f
        La40:
            r0 = move-exception
            r1 = r75
            r21 = r2
            r19 = r3
            r20 = r28
            r12 = r33
            r11 = r35
            r6 = r71
            goto La6f
        La50:
            r0 = move-exception
            r71 = r6
            r1 = r75
            r21 = r2
            r19 = r3
            r20 = r28
            r12 = r33
            r11 = r35
            goto La6f
        La60:
            r0 = move-exception
            r75 = r1
            r71 = r6
            r21 = r2
            r19 = r3
            r20 = r28
            r12 = r33
            r11 = r35
        La6f:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> La9a
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> La9a
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> La9a
            r33 = r12
            r15 = r19
        La7c:
            kotlin.Pair r0 = new kotlin.Pair     // Catch: java.lang.Throwable -> La9a
            double r2 = r15.element     // Catch: java.lang.Throwable -> La9a
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 * r16
            long r2 = java.lang.Math.round(r2)     // Catch: java.lang.Throwable -> La9a
            double r2 = (double) r2     // Catch: java.lang.Throwable -> La9a
            double r2 = r2 / r16
            java.lang.Double r2 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r2)     // Catch: java.lang.Throwable -> La9a
            int r3 = r5.element     // Catch: java.lang.Throwable -> La9a
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)     // Catch: java.lang.Throwable -> La9a
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> La9a
            r5 = r0
            goto Labe
        La9a:
            r0 = move-exception
            r27 = r1
            r51 = r6
            r6 = r21
            goto Lab7
        Laa2:
            r0 = move-exception
            r34 = r74
            r6 = r75
            r27 = r76
            r51 = r30
            goto Lab7
        Laac:
            r0 = move-exception
            r30 = r6
            r34 = r74
            r6 = r75
            r27 = r76
            r51 = r30
        Lab7:
            r21 = r6
            r1 = r27
            r6 = r51
            r5 = 0
        Labe:
            return r5
    }

    private static final java.util.Date fetchBuyMeACoffeeMonthly$parseDate(java.text.SimpleDateFormat r7, java.text.SimpleDateFormat r8, java.lang.String r9) {
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r1 = 0
            if (r0 == 0) goto Lb
            return r1
        Lb:
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = "\\d+"
            r3.<init>(r4)
            boolean r2 = r3.matches(r2)
            if (r2 == 0) goto L5e
            long r2 = java.lang.Long.parseLong(r0)
            int r4 = r0.length()
            r5 = 10
            if (r4 <= r5) goto L35
            r4 = 1
            goto L37
        L35:
            r4 = 1000(0x3e8, double:4.94E-321)
        L37:
            long r2 = r2 * r4
            com.phisher98.donation.DonationManager r4 = com.phisher98.donation.DonationManager.INSTANCE
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L48
            r5 = 0
            java.util.Date r6 = new java.util.Date     // Catch: java.lang.Throwable -> L48
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L48
            java.lang.Object r4 = kotlin.Result.constructor-impl(r6)     // Catch: java.lang.Throwable -> L48
            goto L53
        L48:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.constructor-impl(r4)
        L53:
            boolean r5 = kotlin.Result.isFailure-impl(r4)
            if (r5 == 0) goto L5a
            goto L5b
        L5a:
            r1 = r4
        L5b:
            java.util.Date r1 = (java.util.Date) r1
            return r1
        L5e:
            com.phisher98.donation.DonationManager r2 = com.phisher98.donation.DonationManager.INSTANCE
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L6c
            r3 = 0
            java.util.Date r4 = r7.parse(r0)     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r2 = kotlin.Result.constructor-impl(r4)     // Catch: java.lang.Throwable -> L6c
            goto L77
        L6c:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.constructor-impl(r2)
        L77:
            boolean r3 = kotlin.Result.isFailure-impl(r2)
            if (r3 == 0) goto L7e
            r2 = r1
        L7e:
            java.util.Date r2 = (java.util.Date) r2
            if (r2 != 0) goto Lad
            com.phisher98.donation.DonationManager r2 = com.phisher98.donation.DonationManager.INSTANCE
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L97
            r3 = 0
            r4 = 46
            r5 = 2
            java.lang.String r4 = kotlin.text.StringsKt.substringBefore$default(r0, r4, r1, r5, r1)     // Catch: java.lang.Throwable -> L97
            java.util.Date r4 = r8.parse(r4)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r2 = kotlin.Result.constructor-impl(r4)     // Catch: java.lang.Throwable -> L97
            goto La2
        L97:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.constructor-impl(r2)
        La2:
            boolean r3 = kotlin.Result.isFailure-impl(r2)
            if (r3 == 0) goto La9
            goto Laa
        La9:
            r1 = r2
        Laa:
            r2 = r1
            java.util.Date r2 = (java.util.Date) r2
        Lad:
            return r2
    }

    private final java.lang.String getCurrentMonthName() {
            r4 = this;
            java.lang.String r0 = "UTC"
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "MMMM yyyy"
            java.util.Locale r3 = java.util.Locale.US
            r1.<init>(r2, r3)
            java.util.Date r2 = r0.getTime()
            java.lang.String r2 = r1.format(r2)
            return r2
    }

    private final java.lang.String getDecryptedBmcToken() {
            r9 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L3a
            r0 = r9
            com.phisher98.donation.DonationManager r0 = (com.phisher98.donation.DonationManager) r0     // Catch: java.lang.Throwable -> L3a
            r1 = 0
            java.lang.String r2 = "phisher_cloudstream_bmc_key_2026"
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> L3a
            byte[] r2 = r2.getBytes(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "FREjQw09MzYsBSU+MkIlGykiJzcAKgA2JAwzDGdKewc+ASNKRgALFQsIOCQNPB07UCw5Flc3JxYcKDpuWWlmUhskPSECPEASFyM4JB4pN0JULikeUiA3Cls/LThLfVhvGSQqORkBNTQKIwY/CD4eJ1E7BzMJIDQWHCgTN1p+AHgYJy02Eio2BQs1ODsOPUYgDS8pHhggDg4RKxMKSGpfcBklEzpdKzUJDiEFFh49GSNUOwcOUTckEhIqLRVefl9nCTEDKlwqJhpTNjgjDD4wGR84XwZRNzAWGCwUM1pUcX9GJT0QXCo2BlYhFTRXPh0FDAMAFQ8kCTATKwM4Bn5YXQolLRARKTEVDwknNA08HjdRLCkOGCAZGlsrAxpBeVx4QTEAOl4sGDQbISseUT4OPwwtLhUYNFFmHD8hElt/XkUZCwQlAD8xbhUOAg1ROhhDXE8qNwonFT0mJ0o2AAB4f10lXkIBAxoWEiMJFAIiPB4dOAptCxwMGzMIEiVCdV1sEh09MQ41PGo2A102XR8xJicUHgcpIiEQOAM3HlFvX1glARsrHQA7FigOMEAPKzA7MigrCltYIAU7Az8QUQFBckQZJyw8FkU9DD0IPw8APy0HOD8xKzUOEQ0/AS5eQHpzRCpcPDwHJyhSKFhNIhADNywjJx0uGTwJOS4WawcFd31dHz86WitKPjY7DRsGKUZADDMFMSw9JQwsNwxsVUcKfRoHJBlFVCoSCA0JLCsFA0UtUxg4NwlQbz4gDBxtRgpcAzBYHCc2Nm05Hw0PVTY3PwhXITEaI1cpXVEMCFVdB28EPw9GLRwVMCtVJywAJCMcSDgpaggeDzYzCB1sXGNZZQEnMT0NDyAGLTpfMkk6EQsxPi4QCjw3bgQ1VBxYdVFHPDskCSMUAgpTBgw0ACUsQTAkXjISBSRvLhEVcgt9RXsDIhgGLgQZGFc+DTw1Ghg6ESIMNANbDzMICzILAEUKYEYePTQdDDFsGiEaRjUCIUMdDikmIQAPazE9Cy9eUgB8XQ4INF4LQBRQKAYnCUYCBzpXODoHBTUSOQ0MPAEIZnIfLltEHyohBVUrISAXJ0xDSAJbLDg1KwYlAzYxf1VCZxocXBo7CxATOxQOOhE3IyIXIDIsOjUvBSEzAWlme0hTKkU5PxEkAxkWJjdMDitHOx00LwckPjEdGSsBLmZgS0wyRQAUKyktFiI+BD4tPRY6FA5ZJyw+IC8SKUEddwJfXAlYLEoANAIvEQYpPFEcWTkyMxcSJDU5FSArE2taB0VuHSI7FSI8OREBLVslNgtDOyQ+BCkTDBJnUyQbOXlUWEc4PVwhXVE+LAw5KgwhAUEWVSscGQAMJwpcMCYlcw=="
            byte[] r3 = com.lagradost.cloudstream3.MainAPIKt.base64DecodeArray(r3)     // Catch: java.lang.Throwable -> L3a
            int r4 = r3.length     // Catch: java.lang.Throwable -> L3a
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L3a
            r5 = 0
            int r6 = r3.length     // Catch: java.lang.Throwable -> L3a
        L1e:
            if (r5 >= r6) goto L2e
            r7 = r3[r5]     // Catch: java.lang.Throwable -> L3a
            int r8 = r2.length     // Catch: java.lang.Throwable -> L3a
            int r8 = r5 % r8
            r8 = r2[r8]     // Catch: java.lang.Throwable -> L3a
            r7 = r7 ^ r8
            byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L3a
            r4[r5] = r7     // Catch: java.lang.Throwable -> L3a
            int r5 = r5 + 1
            goto L1e
        L2e:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L3a
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> L3a
            r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r0 = kotlin.Result.constructor-impl(r5)     // Catch: java.lang.Throwable -> L3a
            goto L45
        L3a:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        L45:
            boolean r1 = kotlin.Result.isFailure-impl(r0)
            if (r1 == 0) goto L4d
            java.lang.String r0 = ""
        L4d:
            java.lang.String r0 = (java.lang.String) r0
            return r0
    }

    private final android.content.SharedPreferences getPrefs(android.content.Context r3) {
            r2 = this;
            java.lang.String r0 = "phisher_donation_prefs"
            r1 = 0
            android.content.SharedPreferences r0 = r3.getSharedPreferences(r0, r1)
            return r0
    }

    private final boolean isCooldownActive(android.content.Context r10) {
            r9 = this;
            boolean r0 = com.phisher98.donation.DonationManager.testMode
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            android.content.SharedPreferences r0 = r9.getPrefs(r10)
            java.lang.String r2 = "phisher_donation_last_shown_v2"
            r3 = 0
            long r5 = r0.getLong(r2, r3)
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L17
            return r1
        L17:
            int r2 = com.phisher98.donation.DonationManager.cooldownHours
            long r2 = (long) r2
            r7 = 60
            long r2 = r2 * r7
            long r2 = r2 * r7
            r7 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r7
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r5
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 >= 0) goto L2e
            r1 = 1
        L2e:
            return r1
    }

    private final void recordShown(android.content.Context r10) {
            r9 = this;
            android.content.SharedPreferences r0 = r9.getPrefs(r10)
            r1 = 0
            r2 = 0
            android.content.SharedPreferences$Editor r3 = r0.edit()
            java.lang.String r4 = "editor"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r4 = r3
            r5 = 0
            java.lang.String r6 = "phisher_donation_last_shown_v2"
            long r7 = java.lang.System.currentTimeMillis()
            r4.putLong(r6, r7)
            r3.apply()
            return
    }

    public final void checkAndShow(@org.jetbrains.annotations.NotNull java.lang.String r11) {
            r10 = this;
            com.lagradost.cloudstream3.CloudStreamApp$Companion r0 = com.lagradost.cloudstream3.CloudStreamApp.Companion
            android.content.Context r0 = r0.getContext()
            r1 = 0
            if (r0 != 0) goto L1a
            com.lagradost.cloudstream3.CommonActivity r0 = com.lagradost.cloudstream3.CommonActivity.INSTANCE
            android.app.Activity r0 = r0.getActivity()
            if (r0 == 0) goto L16
            android.content.Context r0 = r0.getApplicationContext()
            goto L17
        L16:
            r0 = r1
        L17:
            if (r0 != 0) goto L1a
            return
        L1a:
            r2 = r0
            java.lang.String r3 = r10.getCurrentMonthName()
            java.lang.Object r4 = com.phisher98.donation.DonationManager.gateLock
            monitor-enter(r4)
            r0 = 0
            boolean r5 = com.phisher98.donation.DonationManager.isLaunching     // Catch: java.lang.Throwable -> L57
            if (r5 != 0) goto L34
            boolean r5 = com.phisher98.donation.DonationManager.isDialogShowing     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L2c
            goto L34
        L2c:
            com.phisher98.donation.DonationManager r5 = com.phisher98.donation.DonationManager.INSTANCE     // Catch: java.lang.Throwable -> L57
            boolean r5 = r5.isCooldownActive(r2)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L36
        L34:
            monitor-exit(r4)
            return
        L36:
            r5 = 1
            com.phisher98.donation.DonationManager.isLaunching = r5     // Catch: java.lang.Throwable -> L57
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L57
            monitor-exit(r4)
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)
            com.phisher98.donation.DonationManager$checkAndShow$2 r0 = new com.phisher98.donation.DonationManager$checkAndShow$2
            r0.<init>(r2, r3, r11, r1)
            r7 = r0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
            return
        L57:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAdSupportButtonText() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.adSupportButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAdSupportUrl() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.adSupportUrl
            return r0
    }

    public final int getCooldownHours() {
            r1 = this;
            int r0 = com.phisher98.donation.DonationManager.cooldownHours
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrency() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.currency
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGoalDescription() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.goalDescription
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGoalTitle() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.goalTitle
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrimaryButtonText() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.primaryButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrimaryDonateUrl() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.primaryDonateUrl
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSecondaryButtonText() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.secondaryButtonText
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSecondaryDonateUrl() {
            r1 = this;
            java.lang.String r0 = com.phisher98.donation.DonationManager.secondaryDonateUrl
            return r0
    }

    public final double getTargetAmount() {
            r5 = this;
            java.lang.String r0 = "UTC"
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)     // Catch: java.lang.Throwable -> L26
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)     // Catch: java.lang.Throwable -> L26
            r1 = 1
            int r1 = r0.get(r1)     // Catch: java.lang.Throwable -> L26
            r2 = 2
            int r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L26
            r3 = 2026(0x7ea, float:2.839E-42)
            if (r1 > r3) goto L23
            if (r1 != r3) goto L20
            r3 = 9
            if (r2 < r3) goto L20
            goto L23
        L20:
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            goto L25
        L23:
            r3 = 4641240890982006784(0x4069000000000000, double:200.0)
        L25:
            goto L29
        L26:
            r0 = move-exception
            double r3 = com.phisher98.donation.DonationManager.targetAmount
        L29:
            return r3
    }

    public final boolean getTestMode() {
            r1 = this;
            boolean r0 = com.phisher98.donation.DonationManager.testMode
            return r0
    }

    public final double getTestProgressAmount() {
            r2 = this;
            double r0 = com.phisher98.donation.DonationManager.testProgressAmount
            return r0
    }

    public final boolean isDialogShowing() {
            r1 = this;
            boolean r0 = com.phisher98.donation.DonationManager.isDialogShowing
            return r0
    }

    public final void setAdSupportButtonText(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.adSupportButtonText = r1
            return
    }

    public final void setAdSupportUrl(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.adSupportUrl = r1
            return
    }

    public final void setCooldownHours(int r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.cooldownHours = r1
            return
    }

    public final void setCurrency(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.currency = r1
            return
    }

    public final void setDialogShowing(boolean r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.isDialogShowing = r1
            return
    }

    public final void setGoalDescription(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.goalDescription = r1
            return
    }

    public final void setGoalTitle(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.goalTitle = r1
            return
    }

    public final void setPrimaryButtonText(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.primaryButtonText = r1
            return
    }

    public final void setPrimaryDonateUrl(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.primaryDonateUrl = r1
            return
    }

    public final void setSecondaryButtonText(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.secondaryButtonText = r1
            return
    }

    public final void setSecondaryDonateUrl(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.secondaryDonateUrl = r1
            return
    }

    public final void setTargetAmount(double r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.targetAmount = r1
            return
    }

    public final void setTestMode(boolean r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.testMode = r1
            return
    }

    public final void setTestProgressAmount(double r1) {
            r0 = this;
            com.phisher98.donation.DonationManager.testProgressAmount = r1
            return
    }
}

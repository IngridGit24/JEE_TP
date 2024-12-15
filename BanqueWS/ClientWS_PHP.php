<?php
// URL du service WSDL
$wsdl = "http://localhost:9191/?wsdl"; 

// Créez un client SOAP
$options = array(
    'trace' => 1,  // Active le traçage pour voir la requête et la réponse
    'exceptions' => true,  // Active les exceptions en cas d'erreur
    'cache_wsdl' => WSDL_CACHE_NONE,  // Désactive la mise en cache du WSDL
);

try {
    // Création du client SOAP avec les options
    $client = new SoapClient($wsdl, $options);

echo"<html>
        <head>
            <title>Test des Méthodes SOAP</title>
            <style>
                body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
                h1 { color: #333; }
                .method-title { color: #444; font-size: 18px; margin-top: 20px; }
                .response { background-color: #fff; padding: 10px; border: 1px solid #ddd; border-radius: 5px; margin-bottom: 20px; }
                .error { color: red; font-weight: bold; }
                pre { font-family: Courier, monospace; background-color: #eee; padding: 10px; border-radius: 5px; }
            </style>
        </head>
        <body>";

        // Test de la méthode 'getCompte'
        echo "<div class='method-title'>Test de la méthode 'getCompte' :</div>";
        $params_getCompte = array('code' => 1000);
        $response_getCompte = $client->__soapCall("getCompte", array($params_getCompte));
    
    echo "<div class='response'><strong>Réponse :</strong><br>";
    print_r($response_getCompte);
    echo "</div>";

    // Test de la méthode 'listComptes'
    echo "<div class='method-title'>Test de la méthode 'listComptes' :</div>";
    $params_listComptes = array();
    $response_listComptes = $client->__soapCall("listComptes", array($params_listComptes));

    echo "<div class='response'><strong>Réponse :</strong><br>";
    print_r($response_listComptes);
    echo "</div>";

    // Test de la méthode 'Convert' avec les bons paramètres
    echo "<div class='method-title'>Test de la méthode 'Convert' :</div>";
    $params_Convert = new stdClass();
    $params_Convert->montant = 100;  // Montant à convertir
    $params_Convert->devise = 'USD'; // Devise de l'argent

    $response_Convert = $client->__soapCall("Convert", array($params_Convert));

    echo "<div class='response'><strong>Réponse :</strong><br>";
    print_r($response_Convert);
    echo "</div>";

} catch (SoapFault $fault) {
    // Gestion des erreurs SOAP
    echo "<div class='error'>Erreur SOAP : " . $fault->getMessage() . "</div>";
}

?>

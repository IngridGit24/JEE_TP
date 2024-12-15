using BanqueWS;
using System;
using System.Threading.Tasks;

class ClientWS
{
    static async Task Main(string[] args)
    {
        var client = new BanqueServiceClient(); 

        try
        {
            var conversionResult = await client.ConvertAsync(800);
            Console.WriteLine($"Conversion de 800 dhs en dollar = {conversionResult}");

            var compteResponse = await client.getCompteAsync(1000);

            if (compteResponse != null && compteResponse.Compte != null)
            {
                Console.WriteLine($"Code du compte: {compteResponse.Compte.Code}");  
                Console.WriteLine($"Solde du compte: {compteResponse.Compte.Solde}"); 
            }
            else
            {
                Console.WriteLine("Compte non trouvé.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erreur : {ex.Message}");
        }
        finally
        {
            // Fermez le client pour libérer les ressources
            client.Close();
        }

        Console.ReadLine();
    }
}
